package br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.user;

import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.entities.UserBucket;
import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.repositories.UserBucketRepository;
import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.buckets.models.BucketDataModel;
import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.user.models.UserRegisteredModel;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    public static final String MSGERROR_USERREGISTRATION_NOTFOUND = "User not found or not have any bucket with owner";

    private final UserBucketRepository userBucketRepository;

    public UserRegistrationServiceImpl(UserBucketRepository userBucketRepository) {
        this.userBucketRepository = userBucketRepository;
    }

    @Override
    public UserRegisteredModel getUserRegistration(String tokenSubject) throws UserRegistrationNotFoundException {
        Set<UserBucket> allByOwnerName = userBucketRepository.findAllByOwnerName(tokenSubject);
        if (allByOwnerName.isEmpty()) {
            throw new UserRegistrationNotFoundException(MSGERROR_USERREGISTRATION_NOTFOUND);
        }
        return UserRegisteredModel.builder()
                .ownerName(tokenSubject)
                .buckets(allByOwnerName.stream().map(BucketDataModel::fromEntity).collect(Collectors.toSet()))
                .build();
    }

}
