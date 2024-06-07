package de.htw.berlinwebtech.webtechprojectportal.service;

import de.htw.berlinwebtech.webtechprojectportal.repository.NotificationRepository;
import de.htw.berlinwebtech.webtechprojectportal.repository.AppUserRepository;
import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import de.htw.berlinwebtech.webtechprojectportal.web.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, AppUserRepository appUserRepository) {
        this.notificationRepository = notificationRepository;
        this.appUserRepository = appUserRepository;
    }

    /**
     * Ruft eine Liste von Benachrichtigungen für einen bestimmten Benutzer anhand der Benutzer-ID ab.
     * @param userId die ID des Benutzers.
     * @return eine Liste von Benachrichtigungen.
     */
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    /**
     * Ruft eine Liste von ungelesenen Benachrichtigungen für einen bestimmten Benutzer anhand der Benutzer-ID ab.
     * @param userId die ID des Benutzers.
     * @return eine Liste von ungelesenen Benachrichtigungen.
     */
    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndIsReadFalse(userId);
    }

    /**
     * Erstellt eine neue Benachrichtigung für einen bestimmten Benutzer.
     * @param message die Nachricht der Benachrichtigung.
     * @param userId die ID des Benutzers, dem die Benachrichtigung zugeordnet wird.
     * @return die erstellte Benachrichtigung.
     */
    public Notification createNotification(String message, Long userId) {
        Optional<AppUser> userOpt = appUserRepository.findById(userId);
        if (userOpt.isPresent()) {
            AppUser user = userOpt.get();
            Notification notification = new Notification();
            notification.setMessage(message);
            notification.setUser(user); // Setzt das vollständige Benutzerobjekt
            notification.setTimestamp(LocalDateTime.now());
            notification.setRead(false);
            return notificationRepository.save(notification);
        } else {
            throw new RuntimeException("Benutzer nicht gefunden");
        }
    }

    /**
     * Markiert eine Benachrichtigung als gelesen anhand ihrer ID.
     * @param notificationId die ID der Benachrichtigung, die als gelesen markiert werden soll.
     * @return ein Optional, das die aktualisierte Benachrichtigung enthält, falls sie gefunden wurde, oder ein leeres Optional, falls nicht.
     */
    public Optional<Notification> markAsRead(Long notificationId) {
        Optional<Notification> notificationOpt = notificationRepository.findById(notificationId);
        if (notificationOpt.isPresent()) {
            Notification notification = notificationOpt.get();
            notification.setRead(true);
            return Optional.of(notificationRepository.save(notification));
        }
        return Optional.empty();
    }

    /**
     * Löscht alle Benachrichtigungen.
     */
    public void deleteAllNotifications() {
        notificationRepository.deleteAll();
    }

    /**
     * Ruft alle Benachrichtigungen ab.
     * @return eine Liste aller Benachrichtigungen.
     */
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
