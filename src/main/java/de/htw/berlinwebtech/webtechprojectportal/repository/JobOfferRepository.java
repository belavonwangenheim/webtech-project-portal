package de.htw.berlinwebtech.webtechprojectportal.repository;

import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
