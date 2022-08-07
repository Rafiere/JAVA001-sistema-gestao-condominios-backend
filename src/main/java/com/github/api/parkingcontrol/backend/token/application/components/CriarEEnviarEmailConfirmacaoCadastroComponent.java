package com.github.api.parkingcontrol.backend.token.application.components;

import com.github.api.parkingcontrol.backend.token.domain.EmailPadrao;
import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CriarEEnviarEmailConfirmacaoCadastroComponent {

    @Value("${environment.email_app}")
    private String emailApp;

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;

    public void execute(TokenEmail tokenEmail) {

        EmailPadrao emailPadrao = criarEmailPadrao(tokenEmail.obterEmailUsuario());

        String templateDoEmail = criarTemplateDoEmailDeConfirmacaoDeCadastro(emailPadrao, tokenEmail.getToken());

        MimeMessage emailConfirmacaoCadastro = criarEmailDeConfirmacaoDeCadastro(emailPadrao, templateDoEmail);

        enviarEmail(emailConfirmacaoCadastro);
    }

    private EmailPadrao criarEmailPadrao(String emailUsuario) {
        return EmailPadrao
                .builder()
                    .de(emailApp)
                    .para(emailUsuario)
                    .assunto("Condogestão - Confirmação de Cadastro")
                    .localizacaoDoTemplate("EmailConfirmacaoCadastroTemplate.html")
                .build();
    }

    private String criarTemplateDoEmailDeConfirmacaoDeCadastro(EmailPadrao emailPadrao,
                                                               String tokenDeVerificacao) {

        Context context = new Context();
        context.setVariables(Map.of("nomeDoCliente", emailPadrao.getPara(),
                "endpointDeConfirmacao", "/confirmarEmail/",
                "tokenDeVerificacao", tokenDeVerificacao));

        return springTemplateEngine.process(
                emailPadrao.getLocalizacaoDoTemplate(),
                context);
    }

    private MimeMessage criarEmailDeConfirmacaoDeCadastro(EmailPadrao emailPadrao, String templateDoEmail) {

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(emailPadrao.getDe());
            mimeMessageHelper.setTo(emailPadrao.getPara());
            mimeMessageHelper.setSubject(emailPadrao.getAssunto());
            mimeMessageHelper.setText(templateDoEmail, true);

        } catch (MessagingException e) {

            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

        return message;
    }

    private void enviarEmail(MimeMessage emailConfirmacaoCadastro) {

        javaMailSender.send(emailConfirmacaoCadastro);
    }
}
