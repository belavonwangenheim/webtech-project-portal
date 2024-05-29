package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;

@Data
public class JobOffer {

    private Long id;
    private String name;
    private String description;
    private String email;
}
