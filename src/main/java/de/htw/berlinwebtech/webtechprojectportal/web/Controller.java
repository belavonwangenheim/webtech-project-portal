package de.htw.berlinwebtech.webtechprojectportal.web;

import de.htw.berlinwebtech.webtechprojectportal.service.JobOfferService;
import de.htw.berlinwebtech.webtechprojectportal.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"https://tempjob-frontend.onrender.com", "http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class Controller {

    private final JobOfferService jobOfferService;
    private final AppUserService appUserService;

    @Autowired
    public Controller(JobOfferService jobOfferService, AppUserService appUserService) {
        this.jobOfferService = jobOfferService;
        this.appUserService = appUserService;
    }

    // Job-APIs
    @GetMapping("/jobs")
    public List<JobOffer> getAllJobs() {
        return jobOfferService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobOffer> getJobById(@PathVariable Long id) {
        return jobOfferService.getJobById(id)
                .map(jobOffer -> ResponseEntity.ok().body(jobOffer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/jobs")
    public JobOffer createJob(@RequestBody JobOffer jobOffer) {
        return jobOfferService.createJob(jobOffer);
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobOfferService.deleteJob(id);
    }

    @PatchMapping("/jobs/{id}")
    public ResponseEntity<JobOffer> updateJob(@PathVariable Long id, @RequestBody JobOffer jobOffer) {
        return jobOfferService.updateJob(id, jobOffer)
                .map(updatedJob -> ResponseEntity.ok().body(updatedJob))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // AppUser-APIs
    @GetMapping("/users")
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return appUserService.getUserById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser user) {
        return appUserService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Optional<AppUser>> updateUser(@PathVariable Long id, @RequestBody AppUser userDetails) {
        return ResponseEntity.ok(appUserService.updateUser(id, userDetails));
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<AppUser> patchUser(@PathVariable Long id, @RequestBody AppUser userDetails) {
        return appUserService.updateUser(id, userDetails)
                .map(updatedUser -> ResponseEntity.ok().body(updatedUser))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere APIs
}
