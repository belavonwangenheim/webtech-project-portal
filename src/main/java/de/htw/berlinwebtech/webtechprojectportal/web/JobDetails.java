package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity

public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jobName;
    private String jobDescription;
    private String jobEmail;
    private String jobPhone;
    private String jobLocation;
    private String jobStartTime;
    private String jobEndTime;
    private String payment;
}
