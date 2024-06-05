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

    public Optional<JobOffer> updateJob(Long id, JobOffer jobOffer) {
        return jobOfferRepository.findById(id)
                .map(existingJob -> {
                    if (jobOffer.getName() != null) existingJob.setName(jobOffer.getName());
                    if (jobOffer.getDescription() != null) existingJob.setDescription(jobOffer.getDescription());
                    if (jobOffer.getEmail() != null) existingJob.setEmail(jobOffer.getEmail());
                    if (jobOffer.getPhoneNumber() != null) existingJob.setPhoneNumber(jobOffer.getPhoneNumber());
                    if (jobOffer.getLocation() != null) existingJob.setLocation(jobOffer.getLocation());
                    if (jobOffer.getSalary() != null) existingJob.setSalary(jobOffer.getSalary());
                    if (jobOffer.getRequirements() != null) existingJob.setRequirements(jobOffer.getRequirements());
                    if (jobOffer.getStartDate() != null) existingJob.setStartDate(jobOffer.getStartDate());
                    if (jobOffer.getEndDate() != null) existingJob.setEndDate(jobOffer.getEndDate());
                    return jobOfferRepository.save(existingJob);
                });
    }
}
