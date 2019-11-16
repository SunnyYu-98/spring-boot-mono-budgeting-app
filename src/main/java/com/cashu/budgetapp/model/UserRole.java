package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    @EmbeddedId
    private UserRoleId userRoleId;

    /*
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private int roleId;
     */
}
