package fr.candidature.fixtures;

import fr.candidature.domain.model.User;

import java.util.UUID;

public class UserFixture {

    public static User getUser() {
        return new User(
                UUID.fromString("886093ba-9053-46ff-af30-b0ce718a33df"),
                "DUPONT",
                "PASCAL",
                "pascal.dupont@xxx.com",
                null);    }
}
