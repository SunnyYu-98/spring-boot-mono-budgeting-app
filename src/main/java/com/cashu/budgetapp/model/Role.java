package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role")
    private String role;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRoleId", targetEntity = UserRoleId.class)
    //private List<UserRole> userRole = new ArrayList<>();
}
