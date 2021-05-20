package kr.co.fastcampus.eatgo.application;

public class EmailExistedException extends RuntimeException{
    public EmailExistedException(String email) {
        super("email is already registered " + email);

    }
}
