package de.htw.berlinwebtech.webtechprojectportal.web;

import de.htw.berlinwebtech.webtechprojectportal.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://tempjob-frontend.onrender.com")
@RestController
@RequestMapping("/api/jobs")
public class Controller {

    private final JobOfferService jobOfferService;

    @Autowired
    public Controller(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping
    public List<JobOffer> getAllJobs() {
        return jobOfferService.getAllJobs();
    }

    @PostMapping
    public JobOffer createJob(@RequestBody JobOffer jobOffer) {
        return jobOfferService.createJob(jobOffer);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobOfferService.deleteJob(id);
    }
}
