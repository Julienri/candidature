package fr.candidature.infrastructure.entity;

import fr.candidature.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getFirstName(),
                userEntity.getEmail(),
                userEntity.getActive());
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getFirstName(),
                user.getEmail(),
                user.getActive());
    }
}
