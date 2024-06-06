package de.htw.berlinwebtech.webtechprojectportal.repository;

import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
