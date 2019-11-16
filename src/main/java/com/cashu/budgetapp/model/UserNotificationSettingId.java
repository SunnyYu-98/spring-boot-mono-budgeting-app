package com.cashu.budgetapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserNotificationSettingId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "event_id")
    private int eventId;
}
