package ru.ftc.android.shifttemple.features.login.domain.model;

public final class User {

    private String sessionId;
    private String name;
    public String username;
    public String lastName;
    public String email;
    public int age;
    public String city;
    public int karma;
    public String type;
    public String roles;
    public String contacts;
    public String firstName;
    public int id;
   /*public User(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
    }*/

    public int getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getName() {
        return name;
    }

    public User(int id, String username, String firstName, String lastName, String email,
                int age, String city, int karma, String type, String roles, String contacts) {
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.city = city;
        this.karma = karma;
        this.type = type;
        this.roles = roles;
        this.contacts = contacts;
        this.firstName=firstName;
        this.id = id;
        this.name = this.firstName;
        this.sessionId = String.valueOf(this.id);
    }

    public User(int age, String city, String contacts, String email, String firstName, String lastName, String username)
    {
        this.age = age;
        this.city = city;
        this.contacts = contacts;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge(){
        return age;
    }

    public String getCity() {
        return city;
    }

    public int getKarma() {
        return karma;
    }

    public String getType() {
        return type;
    }

    public String getRoles() {
        return roles;
    }

    public String getContacts() {
        return contacts;
    }
}