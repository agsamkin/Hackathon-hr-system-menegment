package hackathon.ru.service.mailer;

import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.application.ApplicationStatus;
import hackathon.ru.data.model.candidate.Candidate;
import hackathon.ru.service.application.iService.ApplicationService;
import hackathon.ru.service.application.iService.ApplicationStatusService;
import hackathon.ru.service.mailer.iService.MailerService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static hackathon.ru.config.mailer.MailerConfiguration.GMAIL;


@Service
@AllArgsConstructor
@Transactional
public class MailerServiceImpl implements MailerService {


    private ApplicationService applicationService;
    private ApplicationStatusService applicationStatusService;
    @Override
    public SimpleMailMessage makeRejectMail(long id) {
        updateStatus(id, 4L);
        Candidate candidate = getCandidateByApplicationId(id);
        String mail = candidate.getEmail();
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(GMAIL);
        simpleMail.setTo(mail);
        simpleMail.setSubject("Sorry, " + candidate.getFirstName() + " " + candidate.getLastName() + ", but you didn't get hired");
        simpleMail.setText("Don't feel blue, you will be accepted next time!");
        return simpleMail;
    }

    @Override
    public SimpleMailMessage makeInvitationalMail(long id) {
        updateStatus(id, 3L);
        Candidate candidate = getCandidateByApplicationId(id);
        String mail = candidate.getEmail();
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        StringBuilder stringBuilder = new StringBuilder();
        simpleMail.setFrom(GMAIL);
        simpleMail.setTo(mail);
        simpleMail.setSubject("We like you, but we need more information about you");
        stringBuilder.append("Hello, ").append(candidate.getFirstName()).append(" ").append(candidate.getLastName()).append(".");
        stringBuilder.append("\n We want to invite you, so our hr will contact with you to set time for meeting.");
        simpleMail.setText(String.valueOf(stringBuilder));
        return simpleMail;
    }

    @Override
    public SimpleMailMessage makeOfferMail(long id, int offer) {
        updateStatus(id, 5L);
        Candidate candidate = getCandidateByApplicationId(id);
        String mail = candidate.getEmail();
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        StringBuilder stringBuilder = new StringBuilder();
        simpleMail.setFrom(GMAIL);
        simpleMail.setTo(mail);
        simpleMail.setSubject("Congrats, " + candidate.getFirstName() + " " + candidate.getLastName() + ", You've been accepted");
        stringBuilder.append("We have a good offer for you");
        stringBuilder.append("\n").append(offer);
        simpleMail.setText(String.valueOf(stringBuilder));
        return simpleMail;
    }

    @Override
    public SimpleMailMessage makeAcceptMail(long id) {
        updateStatus(id, 6L);
        Candidate candidate = getCandidateByApplicationId(id);
        String mail = candidate.getEmail();
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(GMAIL);
        simpleMail.setTo(mail);
        simpleMail.setSubject("We really happy, " + candidate.getFirstName() + " " + candidate.getLastName() + ", to see you with us");
        simpleMail.setText("We are waiting you tomorrow");
        return simpleMail;
    }

    @Override
    public SimpleMailMessage makeAgreementMail(long id) {
        updateStatus(id, 2L);
        Application application = applicationService.getApplicationById(id);
        Candidate candidate = application.getCandidate();
        String email = application.getVacancy().getOwner().getEmail();
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(GMAIL);
        simpleMail.setTo(email);
        simpleMail.setSubject("We have a good candidate to get hired");
        simpleMail.setText("тут ссылка на резюме" + candidate.toString());
        return simpleMail;
    }
    public SimpleMailMessage testMail() {
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(GMAIL);
        simpleMail.setTo(GMAIL);
        simpleMail.setSubject("it's working");
        simpleMail.setText("test");
        return simpleMail;
    }

    private Candidate getCandidateByApplicationId(long applicationId) {
        Application application = applicationService.getApplicationById(applicationId);
        return application.getCandidate();
    }

    private void updateStatus(Long applicationId, Long statusId) {
        ApplicationStatus applicationStatus = applicationStatusService.getApplicationStatusById(statusId);
        applicationService.updateApplicationStatus(applicationId, applicationStatus);
    }

}
