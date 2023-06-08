package hackathon.ru.api.impl;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;

import hackathon.ru.api.CalendarApi;
import hackathon.ru.data.dto.calendar.EventDto;
import hackathon.ru.data.model.calendar.Attendee;
import hackathon.ru.data.model.calendar.Calendar;
import hackathon.ru.data.model.calendar.Event;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@Component
public class GoogleCalendarApi implements CalendarApi {
    private static final String APPLICATION_NAME = "Hackathon-hr-system-management";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @Override
    public List<Calendar> getCalendars(String oauth2token)  {

        com.google.api.services.calendar.Calendar service = null;
        try {
            service = getGoogleCalendar(oauth2token);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Calendar> calendars = new ArrayList<>();

        List<CalendarListEntry> googleCalendars = null;
        try {
            googleCalendars = service.calendarList().list().execute().getItems();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (CalendarListEntry googleCalendar : googleCalendars) {
            if (Objects.nonNull(googleCalendar.getDeleted()) && googleCalendar.getDeleted()) {
                continue;
            }

            Calendar calendar = Calendar.builder()
                    .calendarId(googleCalendar.getId())
                    .summery(googleCalendar.getSummary())
                    .description(googleCalendar.getDescription()).build();
            calendars.add(calendar);
        }

        return calendars;
    }

    @Override
    public Event createEvent(String oauth2token, String calendarId, EventDto eventDto) {
        // TODO: Надо учитывать timezone, для демо берем одну дефолтную
        final String timeZoneDefault = "Europe/Moscow";

        final String responseStatusDefault = "needsAction";

        com.google.api.services.calendar.Calendar service = null;
        try {
            service = getGoogleCalendar(oauth2token);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        com.google.api.services.calendar.model.Event googleEvent
                = new com.google.api.services.calendar.model.Event();

        googleEvent.setSummary(eventDto.getSummary());
        googleEvent.setLocation(eventDto.getLocation());
        googleEvent.setDescription(eventDto.getDescription());

        EventDateTime start = new EventDateTime()
                .setDateTime(toGoogleDateTime(eventDto.getStart(), timeZoneDefault))
                .setTimeZone(timeZoneDefault);
        googleEvent.setStart(start);

        EventDateTime end = new EventDateTime()
                .setDateTime(toGoogleDateTime(eventDto.getEnd(), timeZoneDefault))
                .setTimeZone(timeZoneDefault);
        googleEvent.setEnd(end);

        List<String> attendees = eventDto.getAttendees();
        List<EventAttendee> googleAttendees = new ArrayList<>();
        for (String attendee : attendees) {
            googleAttendees.add(new EventAttendee().setEmail(attendee).setResponseStatus(responseStatusDefault));
        }
        googleEvent.setAttendees(googleAttendees);

        com.google.api.services.calendar.model.Event event = null;
        try {
            // TODO: Необходимо отслеживать ответы по приглашегниям и менять статусы приглашаемых
            event = service.events().insert("primary", googleEvent)
                    .setSendNotifications(true)
                    .setSendUpdates("all").execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Attendee> attendeesList = new ArrayList<>();
        for (EventAttendee attendee : event.getAttendees()) {
            attendeesList.add(Attendee.builder()
                            .attendeeId(attendee.getId())
                            .name(attendee.getDisplayName())
                            .comment(attendee.getComment())
                            .email(attendee.getEmail())
                            .responseStatus(attendee.getResponseStatus()).build());
        }

        return Event.builder()
                .eventId(event.getId())
                .creator(event.getCreator().getEmail())
                .organizer(event.getOrganizer().getId())
                .start(toDate(event.getStart().getDateTime()))
                .end(toDate(event.getEnd().getDateTime()))
                .description(event.getDescription())
                .htmlLink(event.getHtmlLink())
                .status(event.getStatus())
                .createdAt(toDate(event.getCreated()))
                .updatedAt(toDate(event.getUpdated()))
                .attendees(attendeesList).build();
    }

    private com.google.api.services.calendar.Calendar getGoogleCalendar(String userToken)
            throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new com.google.api.services.calendar.Calendar
                .Builder(httpTransport, JSON_FACTORY, getCredential(userToken))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
    }

    private Credential getCredential(String userToken) {
        Credential credential = new GoogleCredential()
                .setAccessToken(userToken);
        return credential;
    }

    private DateTime toGoogleDateTime(LocalDateTime dateTime, String zoneId) {
        ZonedDateTime zdtSource = dateTime.atZone(ZoneId.of(zoneId));
        Date date = Date.from(zdtSource.toInstant());
        return new DateTime(date, TimeZone.getTimeZone(ZoneId.of(zoneId)));
    }

    private Date toDate(DateTime dateTime) {
        return new Date(dateTime.getValue());
    }
}
