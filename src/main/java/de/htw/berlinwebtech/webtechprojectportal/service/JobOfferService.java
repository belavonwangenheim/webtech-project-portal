package de.htw.berlinwebtech.webtechprojectportal.service;

import de.htw.berlinwebtech.webtechprojectportal.repository.JobOfferRepository;
import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferService {

    private final JobOfferRepository jobOfferRepository;

    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public List<JobOffer> getAllJobs() {
        return jobOfferRepository.findAll();
    }

    public JobOffer createJob(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public void deleteJob(Long id) {
        jobOfferRepository.deleteById(id);
    }

    public Optional<JobOffer> getJobById(Long id) {
        return jobOfferRepository.findById(id);
    }
}
