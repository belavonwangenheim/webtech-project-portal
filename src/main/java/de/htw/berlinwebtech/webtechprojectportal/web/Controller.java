package de.htw.berlinwebtech.webtechprojectportal.web;

import de.htw.berlinwebtech.webtechprojectportal.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://tempjob-frontend.onrender.com", "http://localhost:5173"})
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

    @GetMapping("/{id}")
    public ResponseEntity<JobOffer> getJobById(@PathVariable Long id) {
        return jobOfferService.getJobById(id)
                .map(jobOffer -> ResponseEntity.ok().body(jobOffer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public JobOffer createJob(@RequestBody JobOffer jobOffer) {
        return jobOfferService.createJob(jobOffer);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobOfferService.deleteJob(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<JobOffer> updateJob(@PathVariable Long id, @RequestBody JobOffer jobOffer) {
        return jobOfferService.updateJob(id, jobOffer)
                .map(updatedJob -> ResponseEntity.ok().body(updatedJob))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
