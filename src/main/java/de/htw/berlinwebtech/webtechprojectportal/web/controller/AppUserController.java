package de.htw.berlinwebtech.webtechprojectportal.web.controller;

import de.htw.berlinwebtech.webtechprojectportal.service.AppUserService;
import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"https://tempjob-frontend.onrender.com", "http://localhost:5173"})
@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return appUserService.getUserById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return appUserService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<AppUser>> updateUser(@PathVariable Long id, @RequestBody AppUser userDetails) {
        return ResponseEntity.ok(appUserService.updateUser(id, userDetails));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppUser> patchUser(@PathVariable Long id, @RequestBody AppUser userDetails) {
        return appUserService.updateUser(id, userDetails)
                .map(updatedUser -> ResponseEntity.ok().body(updatedUser))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
