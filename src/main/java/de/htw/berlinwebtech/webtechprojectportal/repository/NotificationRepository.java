package de.htw.berlinwebtech.webtechprojectportal.repository;

import de.htw.berlinwebtech.webtechprojectportal.web.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
    List<Notification> findByUserIdAndReadFalse(Long userId);
}
