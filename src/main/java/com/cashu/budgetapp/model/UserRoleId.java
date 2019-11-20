package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserRoleId implements Serializable {
    //@OneToOne(targetEntity = User.class)
    //@JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private Long userId;

    //@ManyToOne(targetEntity = Role.class)
    //@JoinColumn(name = "role_id")
    @Column(name = "role_id")
    private int roleId;

    public int getRoleId(){
        return roleId;
    }

}
