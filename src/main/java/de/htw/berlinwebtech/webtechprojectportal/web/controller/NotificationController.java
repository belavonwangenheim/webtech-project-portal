/**
    Diese Klasse stellt REST-Endpunkte für Benachrichtigungen bereit.
    Endpunkte können über die folgenden URLs getestet werden:
    Render URL: https://webtech-project-backend.onrender.com/api
    Lokale URL: http://localhost:8080/api
*/

package de.htw.berlinwebtech.webtechprojectportal.web.controller;

import de.htw.berlinwebtech.webtechprojectportal.service.NotificationService;
import de.htw.berlinwebtech.webtechprojectportal.web.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /*
     * GET /api/notifications/user/{userId}
     * Diese Methode gibt alle Benachrichtigungen eines bestimmten Benutzers zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/notifications/user/{userId}
     *         http://localhost:8080/api/notifications/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable Long userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    /*
     * GET /api/notifications/unread/{userId}
     * Diese Methode gibt alle ungelesenen Benachrichtigungen eines bestimmten Benutzers zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/notifications/unread/{userId}
     *         http://localhost:8080/api/notifications/unread/{userId}
     */
    @GetMapping("/unread/{userId}")
    public List<Notification> getUnreadNotificationsByUserId(@PathVariable Long userId) {
        return notificationService.getUnreadNotificationsByUserId(userId);
    }

    /*
     * POST /api/notifications
     * Diese Methode erstellt eine neue Benachrichtigung.
     * Testen: https://webtech-project-backend.onrender.com/api/notifications
     *         http://localhost:8080/api/notifications
     */
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification.getMessage(), notification.getUser().getId());
    }

    /*
     * PATCH /api/notifications/{notificationId}
     * Diese Methode markiert eine Benachrichtigung als gelesen.
     * Testen: https://webtech-project-backend.onrender.com/api/notifications/{notificationId}
     *         http://localhost:8080/api/notifications/{notificationId}
     */
    @PatchMapping("/{notificationId}")
    public ResponseEntity<Notification> markAsRead(@PathVariable Long notificationId) {
        return notificationService.markAsRead(notificationId)
                .map(updatedNotification -> ResponseEntity.ok().body(updatedNotification))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * DELETE /api/notifications/all
     * Diese Methode löscht alle Benachrichtigungen.
     * Testen: https://webtech-project-backend.onrender.com/api/notifications/all
     *         http://localhost:8080/api/notifications/all
     */
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllNotifications() {
        notificationService.deleteAllNotifications();
        return ResponseEntity.noContent().build();
    }

    /*
     * GET /api/notifications
     * Diese Methode gibt alle Benachrichtigungen zurück.
     * Testen: https://webtech-project-backend.onrender.com/api/notifications
     *         http://localhost:8080/api/notifications
     */
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}
