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
}
