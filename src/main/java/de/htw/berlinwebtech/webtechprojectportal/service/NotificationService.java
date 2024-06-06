package de.htw.berlinwebtech.webtechprojectportal.service;

import de.htw.berlinwebtech.webtechprojectportal.web.AppUser;
import de.htw.berlinwebtech.webtechprojectportal.web.Notification;
import de.htw.berlinwebtech.webtechprojectportal.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final AppUserService appUserService;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, AppUserService appUserService) {
        this.notificationRepository = notificationRepository;
        this.appUserService = appUserService;
    }

    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndReadFalse(userId);
    }

    public Notification createNotification(String message, Long userId) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setRead(false);
        notification.setTimestamp(LocalDateTime.now());
        AppUser user = appUserService.getUserById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        notification.setUser(user);
        return notificationRepository.save(notification);
    }

    public Optional<Notification> markAsRead(Long notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        notification.ifPresent(n -> {
            n.setRead(true);
            notificationRepository.save(n);
        });
        return notification;
    }
}
