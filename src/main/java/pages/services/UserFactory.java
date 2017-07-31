package pages.services;

import pages.business_objects.User;

public class UserFactory {

    public User createUser() {
        User userData = new User();
        userData.setEmailUrl("https://mail.yandex.by/");
        userData.setLogin("yalogintest");
        userData.setPassword("yalogintest123");
        return userData;
    }
}
