package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class Application {
    private Long ApplicationId;
    private String jobID;
    private LocalDate applicationDate;
    private String status;

}
