package de.htw.berlinwebtech.webtechprojectportal.service;

import de.htw.berlinwebtech.webtechprojectportal.repository.AppUserRepository;
import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> getUserById(Long id) {
        return appUserRepository.findById(id);
    }

    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public Optional<AppUser> authenticate(String username, String password) {
        return appUserRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<AppUser> updateUser(Long id, AppUser userDetails) {
        return appUserRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setPassword(userDetails.getPassword());
                    user.setFirstName(userDetails.getFirstName());
                    user.setLastName(userDetails.getLastName());
                    user.setEmail(userDetails.getEmail());
                    user.setPhone(userDetails.getPhone());
                    user.setBirthDate(userDetails.getBirthDate());
                    user.setAddress(userDetails.getAddress());
                    return appUserRepository.save(user);
                });
    }

    public void deleteUser(Long id) {
        appUserRepository.deleteById(id);
    }
}
