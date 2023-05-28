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

    private final MailerService mail;
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Send Invitation to interview")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping("/invitation" + ID)
    public void sendInvitation(@PathVariable("id") final long id) {
        emailSender.send(mail.makeInvitationalMail(id));
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Send Reject message")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping("/reject" + ID)
    public void sendRejection(@PathVariable("id") final long id) {
        emailSender.send(mail.makeRejectMail(id));
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping("/offer" + ID)
    public void sendOfferMessage(@PathVariable("id") final long id) {
        emailSender.send(mail.makeOfferMail(id, 50));
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping("/agreement" + ID)
    public void sendAgreementMessage(@PathVariable("id") final long id) {
        emailSender.send(mail.makeAgreementMail(id));
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping("/accept" + ID)
    public void sendAcceptMessage(@PathVariable("id") final long id) {
        emailSender.send(mail.makeAcceptMail(id));
    }
    @CrossOrigin(origins = "https://prokhorov97.github.io")
    @Operation(summary = "Send Offer")
    @ApiResponse(responseCode = "201", description = "Message send")
    @ResponseStatus(CREATED)
    @PostMapping("/test")
    public void test() {
        emailSender.send(mail.testMail());
    }
}
