package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "user_event")
public class UserEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventID;

    @Column(name = "event_name")
    private String eventName;
}
