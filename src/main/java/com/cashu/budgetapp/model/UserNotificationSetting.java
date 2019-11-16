package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_notification_setting")
public class UserNotificationSetting implements Serializable {

    @EmbeddedId
    private UserNotificationSettingId userNotificationSettingId;

    @Column(name = "notification_type")
    private String notificationType;
}
