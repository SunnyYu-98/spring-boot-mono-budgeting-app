package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_notification_setting")
public class UserNotificationSetting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_set_id")
    private Long notificationSettingId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = UserEvent.class)
    @JoinColumn(name = "event_id")
    private UserEvent event;

    @Column(name = "notification_type")
    private String notificationType;

    public Long getNotificationSettingId() {
        return notificationSettingId;
    }

    public User getUser() {
        return user;
    }

    public UserEvent getEvent() {
        return event;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationSettingId(Long notificationSettingId) {
        this.notificationSettingId = notificationSettingId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(UserEvent event) {
        this.event = event;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
