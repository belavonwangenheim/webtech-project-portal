package de.htw.berlinwebtech.webtechprojectportal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://tempjob-frontend.onrender.com")
@RestController
@RequestMapping("/api/jobs")
public class Controller {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @GetMapping
    public List<JobOffer> getAllJobs() {
        return jobOfferRepository.findAll();
    }

    @PostMapping
    public JobOffer createJob(@RequestBody JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobOfferRepository.deleteById(id);
    }
}
