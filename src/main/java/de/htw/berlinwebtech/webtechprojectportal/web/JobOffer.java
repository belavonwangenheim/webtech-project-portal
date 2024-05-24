package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class JobOffer {

    // Getter und Setter
    private Long id;
    private String name;
    private String description;
    private String email;

}
