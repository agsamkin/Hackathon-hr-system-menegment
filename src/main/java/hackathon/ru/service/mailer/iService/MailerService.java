package hackathon.ru.service.mailer.iService;

import org.springframework.mail.SimpleMailMessage;

public interface MailerService {
    SimpleMailMessage makeRejectMail(long id);
    SimpleMailMessage makeInvitationalMail(long id);
    SimpleMailMessage makeOfferMail(long id, int offer);
    SimpleMailMessage makeAcceptMail(long id);
    SimpleMailMessage makeAgreementMail(long id);
    SimpleMailMessage testMail();
}
