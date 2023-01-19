package br.com.marcoshssilva.mhpasswordmanager.oauth2.authorization.server.domain.data.models;

import br.com.marcoshssilva.mhpasswordmanager.oauth2.authorization.server.domain.validations.EmailHasUsedForOtherAccount;
import br.com.marcoshssilva.mhpasswordmanager.oauth2.authorization.server.domain.validations.UserRegistrationMustHavePasswordAndConfirmationEquals;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(access = AccessLevel.PUBLIC)
@UserRegistrationMustHavePasswordAndConfirmationEquals(message = "A senha e contra-senha devem ser identicos")
public class UserRegistrationData {

    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "Deve ser um email válido")
    @EmailHasUsedForOtherAccount(message = "Este email já é utilizado por outro usuário")
    private String email;
    @NotBlank(message = "O nome não pode ser vazio")
    private String firstName;
    @NotBlank(message = "O sobrenome não pode ser vazio")
    private String lastName;
    @NotBlank(message = "A senha não pode ser vazio")
    @Size(min = 8, max = 64)
    @Pattern(regexp = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/")
    private String password;
    @NotBlank(message = "O contra-senha não pode ser vazio")
    @Size(min = 8, max = 64)
    private String confirmationPassword;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistrationData that = (UserRegistrationData) o;
        return Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(password, that.password) && Objects.equals(confirmationPassword, that.confirmationPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, password, confirmationPassword);
    }
}