package com.github.api.parkingcontrol.backend.usuario.adapter.in.web.requests;

import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    List<Cargo> cargos;
}
