package hackathon.ru.api;

import hackathon.ru.api.impl.GoogleCalendarApi;
import hackathon.ru.api.impl.OutlookCalendarApi;

import static hackathon.ru.api.CalendarApiType.GOOGLE;
import static hackathon.ru.api.CalendarApiType.OUTLOOK;

public class CalendarApiFactory {
    //TODO: можно предоставить выбор для интеграции с типом календаря
    public static CalendarApi getCalendarApi(CalendarApiType type) {
        if (GOOGLE.equals(type)) {
            return new GoogleCalendarApi();
        } else if (OUTLOOK.equals(type)) {
            new OutlookCalendarApi();
        }
        throw new RuntimeException("This api type is not supported");
    }
}
