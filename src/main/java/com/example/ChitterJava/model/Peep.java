package com.example.ChitterJava.model;

public class Peep {

    private final int id;
    private final String user;
    private final String message;

    public Peep(int id, String user, String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return String.format("Peep[%d, %s, %s]", id, user, message);
    }
}
