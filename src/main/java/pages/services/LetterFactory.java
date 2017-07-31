package pages.services;

import pages.business_objects.Letter;

public class LetterFactory {

    public Letter createLetter() {
        Letter letterData = new Letter();
        letterData.setAddress("test2.asd@yandex.ru");
        letterData.setSubject("test email");
        letterData.setBody("test text here21231");
        return letterData;
    }
}
