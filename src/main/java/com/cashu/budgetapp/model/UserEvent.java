package com.cashu.budgetapp.model;

import javax.persistence.*;

@Entity
@Table (name = "user_event")
public class UserEvent {

    // Event ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventID;

    // Event name
    @Column(name = "event_name")
    private String eventName;


}
