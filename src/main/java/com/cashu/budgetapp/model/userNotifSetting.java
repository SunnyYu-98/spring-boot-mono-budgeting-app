package com.cashu.budgetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "user_notification_setting")
public class userNotifSetting {

    // notification type
    @Column(name = "notification_type")
    private int notifType;

    // FK are user and event ID
}
