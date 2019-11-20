package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    //java.sql.Date instead of java.util.Date
    @Column(name = "birth_date")
    private java.sql.Date birthDate;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "num_of_failed_logins")
    private int numberOfFailedLogins;

    @Column(name = "phone_num")
    private String phoneNumber;

    @Column(name = "is_locked")
    private boolean isLocked;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "budget_type")
    private String budgetType;

    @Column(name = "created_date")
    private java.util.Date createdDate;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Expenses.class)
    private List<Expenses> allExpenses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserNotificationSetting.class)
    private List<UserNotificationSetting> allNotificationSettings = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserCategoryBudget.class)
    private List<UserCategoryBudget> allUserBudgets = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserRole.class)
    private List<UserRole> userRole = new ArrayList<>();

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
