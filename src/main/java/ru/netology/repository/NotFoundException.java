package ru.netology.repository;

public class NotFoundException extends RuntimeException {
    String message;

    public NotFoundException(String str) {
        message = str;
        printStackTrace();
    }

    public String toString() {
        return ("NotFoundException Occurred: " + message);
    }

}
