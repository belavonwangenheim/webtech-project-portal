/**
 Diese Klasse stellt REST-Endpunkte für App-User bereit.
 Endpunkte können über die folgenden URLs getestet werden:
 Render URL: https://webtech-project-backend.onrender.com/api
 Lokale URL: http://localhost:8080/api
 */
package de.htw.berlinwebtech.webtechprojectportal.web.controller;

import de.htw.berlinwebtech.webtechprojectportal.service.AppUserService;
import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    /*
     * GET /api/users
     * Diese Methode gibt alle Benutzer zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/users
     *         http://localhost:8080/api/users
     */
    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    /*
     * GET /api/users/{id}
     * Diese Methode gibt einen Benutzer anhand der ID zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/users/{id}
     *         http://localhost:8080/api/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return appUserService.getUserById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST /api/users
     * Diese Methode erstellt einen neuen Benutzer.
     * Testen: https://webtech-project-backend.onrender.com/api/users
     *         http://localhost:8080/api/users
     */
    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return appUserService.createUser(user);
    }

    /*
     * POST /api/users/login
     * Diese Methode überprüft die Anmeldeinformationen des Benutzers.
     * Testen: https://webtech-project-backend.onrender.com/api/users/login
     *         http://localhost:8080/api/users/login
     */
    @PostMapping("/login")
    public ResponseEntity<AppUser> loginUser(@RequestBody AppUser user) {
        Optional<AppUser> userOpt = appUserService.authenticate(user.getUsername(), user.getPassword());
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /*
     * PUT /api/users/{id}
     * Diese Methode aktualisiert einen bestehenden Benutzer vollständig.
     * Testen: https://webtech-project-backend.onrender.com/api/users/{id}
     *         http://localhost:8080/api/users/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Optional<AppUser>> updateUser(@PathVariable Long id, @RequestBody AppUser userDetails) {
        return ResponseEntity.ok(appUserService.updateUser(id, userDetails));
    }

    /*
     * PATCH /api/users/{id}
     * Diese Methode aktualisiert einen bestehenden Benutzer teilweise.
     * Testen: https://webtech-project-backend.onrender.com/api/users/{id}
     *         http://localhost:8080/api/users/{id}
     */
    @PatchMapping("/{id}")
    public ResponseEntity<AppUser> patchUser(@PathVariable Long id, @RequestBody AppUser userDetails) {
        return appUserService.updateUser(id, userDetails)
                .map(updatedUser -> ResponseEntity.ok().body(updatedUser))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * DELETE /api/users/{id}
     * Diese Methode löscht einen Benutzer anhand der ID.
     * Testen: https://webtech-project-backend.onrender.com/api/users/{id}
     *         http://localhost:8080/api/users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
