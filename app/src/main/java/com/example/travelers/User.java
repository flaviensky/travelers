package com.example.travelers;

class User {


private String firstName;
private String lastName;
private String birthday;
private String email;
private String phone;
private String profilePicture;

    public User(String firstName, String lastName, String birthday, String email, String phone, String profilPicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.profilePicture = profilPicture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilPicture() {
        return profilePicture;
    }

    public void setProfilPicture(String profilPicture) {
        this.profilePicture = profilPicture;
    }
}
