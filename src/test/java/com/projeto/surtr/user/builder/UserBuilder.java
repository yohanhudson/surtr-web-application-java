package com.projeto.surtr.user.builder;

import com.projeto.surtr.entities.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserBuilder {

    public UserBuilder() {
        throw new IllegalStateException("Classe Utilitária");
    }

    public static User createUser() {
        LocalDate birthDate = LocalDate.parse("1997-05-06", DateTimeFormatter.ISO_LOCAL_DATE);
        return new User(1L, "Alice Kuromi", "alice.kuromi@exemplo.com", "42748536088", birthDate, "Teste@31415");
    }
}
