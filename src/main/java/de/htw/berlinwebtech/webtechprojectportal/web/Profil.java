package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Profil {
    private int profilId;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;

    private String email;
    private String phone;

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    private String description;
    private String qualification;

    private byte[] image;

}
