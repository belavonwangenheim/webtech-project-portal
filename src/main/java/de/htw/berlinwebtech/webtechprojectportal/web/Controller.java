package de.htw.berlinwebtech.webtechprojectportal.web;

import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public ModelAndView showProject() {
        return new ModelAndView("TempJobOffer");
    }

    @GetMapping("/jobOffers")
    public List<JobOffer> getJobOffers() {
        List<JobOffer> jobOffers = new ArrayList<>();

        // Beispiel-Jobangebote hinzufügen
        jobOffers.add(new JobOffer(1L, "Software Engineer", "Entwickelt Softwarelösungen für Kunden", "Berlin", "123-456-789", "info@example.com", 60000.00, LocalDate.of(2024, 6, 1), 30));
        // Weitere Jobangebote hinzufügen...

        return jobOffers;
    }
}
