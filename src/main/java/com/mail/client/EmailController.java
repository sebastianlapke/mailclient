package com.mail.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;
    MailclientApplication mailclientApplication = new MailclientApplication();
    @GetMapping("/email")
    public String emailFrom(Model model) {
        model.addAttribute("email", new Email());
        return "email";
    }

    @PostMapping("/email")
    public String emailSubmit(@ModelAttribute Email email, Model model) {
        model.addAttribute("email", email);
        mailclientApplication.sendEmail(javaMailSender, email.getRecipient(), email.getContent(), email.getSubject());
        return "result";
    }

}