package de.htw.berlinwebtech.webtechprojectportal.web;

import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@RestController
public class Controller {

    private List<JobOffer> jobOffers = new ArrayList<>();

    public Controller() {
        // Weitere Jobangebote hinzufügen...
    }

    @GetMapping("/")
    public String showProject() {
        return "TempJobOffer";
    }

    @GetMapping("/jobOffers")
    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }
}
