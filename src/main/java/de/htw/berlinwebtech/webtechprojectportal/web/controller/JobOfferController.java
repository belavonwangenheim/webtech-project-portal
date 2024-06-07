/**
    Diese Klasse stellt REST-Endpunkte für Jobangebote bereit.
    Endpunkte können über die folgenden URLs getestet werden:
    Render URL: https://webtech-project-backend.onrender.com/api
    Lokale URL: http://localhost:8080/api
*/

package de.htw.berlinwebtech.webtechprojectportal.web.controller;

import de.htw.berlinwebtech.webtechprojectportal.service.JobOfferService;
import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://tempjob-frontend.onrender.com", "http://localhost:5173"})
@RestController
@RequestMapping("/api/jobs")
public class JobOfferController {

    private final JobOfferService jobOfferService;

    @Autowired
    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    /*
     * GET /api/jobs
     * Diese Methode gibt alle Jobangebote zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/jobs
     *         http://localhost:8080/api/jobs
     */
    @GetMapping
    public List<JobOffer> getAllJobs() {
        return jobOfferService.getAllJobs();
    }

    /*
     * GET /api/jobs/{id}
     * Diese Methode gibt ein Jobangebot anhand der ID zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/jobs/{id}
     *         http://localhost:8080/api/jobs/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<JobOffer> getJobById(@PathVariable Long id) {
        return jobOfferService.getJobById(id)
                .map(jobOffer -> ResponseEntity.ok().body(jobOffer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST /api/jobs
     * Diese Methode erstellt ein neues Jobangebot.
     * Testen: https://webtech-project-backend.onrender.com/api/jobs
     *         http://localhost:8080/api/jobs
     */
    @PostMapping
    public JobOffer createJob(@RequestBody JobOffer jobOffer) {
        return jobOfferService.createJob(jobOffer);
    }

    /*
     * DELETE /api/jobs/{id}
     * Diese Methode löscht ein Jobangebot anhand der ID.
     * Testen: https://webtech-project-backend.onrender.com/api/jobs/{id}
     *         http://localhost:8080/api/jobs/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobOfferService.deleteJob(id);
    }

    /*
     * PATCH /api/jobs/{id}
     * Diese Methode aktualisiert ein bestehendes Jobangebot teilweise.
     * Testen: https://webtech-project-backend.onrender.com/api/jobs/{id}
     *         http://localhost:8080/api/jobs/{id}
     */
    @PatchMapping("/{id}")
    public ResponseEntity<JobOffer> updateJob(@PathVariable Long id, @RequestBody JobOffer jobOffer) {
        return jobOfferService.updateJob(id, jobOffer)
                .map(updatedJob -> ResponseEntity.ok().body(updatedJob))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
