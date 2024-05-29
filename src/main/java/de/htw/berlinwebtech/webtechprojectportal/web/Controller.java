package de.htw.berlinwebtech.webtechprojectportal.web;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://tempjob-frontend.onrender.com")
@RestController
@RequestMapping("/api/jobs")
public class Controller {

    private List<JobOffer> jobOffers = new ArrayList<>();

    @GetMapping
    public List<JobOffer> getAllJobs() {
        return jobOffers;
    }

    @PostMapping
    public JobOffer createJob(@RequestBody JobOffer jobOffer) {
        jobOffers.add(jobOffer);
        return jobOffer;
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobOffers.removeIf(jobOffer -> jobOffer.getId().equals(id));
    }
}
