package de.htw.berlinwebtech.webtechprojectportal.repository;

import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
