package de.htw.berlinwebtech.webtechprojectportal.service;

import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import de.htw.berlinwebtech.webtechprojectportal.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferService {

    private final JobOfferRepository jobOfferRepository;
    private final NotificationService notificationService;

    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository, NotificationService notificationService) {
        this.jobOfferRepository = jobOfferRepository;
        this.notificationService = notificationService;
    }

    public List<JobOffer> getAllJobs() {
        return jobOfferRepository.findAll();
    }

    public Optional<JobOffer> getJobById(Long id) {
        return jobOfferRepository.findById(id);
    }

    public JobOffer createJob(JobOffer jobOffer) {
        JobOffer createdJob = jobOfferRepository.save(jobOffer);
        notificationService.createNotification("Dein neuer Eintrag wurde erstellt.", jobOffer.getUserId());
        return createdJob;
    }

    public Optional<JobOffer> updateJob(Long id, JobOffer jobOffer) {
        if (jobOfferRepository.existsById(id)) {
            jobOffer.setId(id);
            return Optional.of(jobOfferRepository.save(jobOffer));
        }
        return Optional.empty();
    }

    public void deleteJob(Long id) {
        jobOfferRepository.deleteById(id);
    }
}
