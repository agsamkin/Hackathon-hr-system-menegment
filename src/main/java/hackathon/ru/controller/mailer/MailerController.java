package hackathon.ru.controller.mailer;


import hackathon.ru.service.mailer.iService.MailerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Mailer Controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + MailerController.MAIL)
public class MailerController {

    private JavaMailSender emailSender;
    public final static String MAIL= "/mail";
    public static final String ID = "/{id}";
    private final static String INVITATION = "/invitation";
    private final static String REJECT = "/reject";
    private final static String OFFER = "/offer";
    private final static String AGREEMENT = "/agreement";
    private final static String ACCEPT = "/accept";


    private final MailerService mail;

    @Operation(summary = "Send Invitation to interview")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping( INVITATION + ID)
    public void sendInvitation(@PathVariable("id") final long id) {
        emailSender.send(mail.makeInvitationalMail(id));
    }

    @Operation(summary = "Send Reject message")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping(REJECT + ID)
    public void sendRejection(@PathVariable("id") final long id) {
        emailSender.send(mail.makeRejectMail(id));
    }

    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping(OFFER + ID)
    public void sendOfferMessage(@PathVariable("id") final long id) {
        emailSender.send(mail.makeOfferMail(id, 50));
    }

    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping(AGREEMENT + ID)
    public void sendAgreementMessage(@PathVariable("id") final long id) {
        emailSender.send(mail.makeAgreementMail(id));
    }

    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping(ACCEPT + ID)
    public void sendAcceptMessage(@PathVariable("id") final long id) {
        emailSender.send(mail.makeAcceptMail(id));
    }

    @ResponseStatus(CREATED)
    @PostMapping("/test")
    public void test() {
        emailSender.send(mail.testMail());
    }
}
