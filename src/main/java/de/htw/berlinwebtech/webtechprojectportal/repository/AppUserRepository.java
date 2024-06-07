package de.htw.berlinwebtech.webtechprojectportal.repository;

import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsernameAndPassword(String username, String password);
}
