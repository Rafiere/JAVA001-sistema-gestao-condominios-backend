package com.github.api.parkingcontrol.backend.usuario.adapter.in.web.requests;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
public class CadastrarUsuarioRequest {

    @Email(message = "Por favor, envie um email em um formato válido.")
    @NotBlank
    String email;

    @Length(min = 1, max = 16, message = "O nome de usuário deve ter no máximo 16 caracteres.")
    @NotBlank
    String username;

    @Length(min = 6, max = 16, message = "A senha deve ter no mínimo 6 caracteres e no máximo 16 caracteres.")
    @NotBlank
    String password;

    @NotEmpty
    List<String> idsCargosDoUsuario;
}
