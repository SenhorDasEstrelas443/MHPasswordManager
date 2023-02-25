package br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.user;

import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.user.models.UserRegisteredModel;

public interface UserRegistrationService {
    UserRegisteredModel createUserRegistration(String email, String vaultKey) throws UserRegistrationException;
}