package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
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

    public Long getUserId() {
        return userId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getNumberOfFailedLogins() {
        return numberOfFailedLogins;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public List<Expenses> getAllExpenses() {
        return allExpenses;
    }

    public List<UserNotificationSetting> getAllNotificationSettings() {
        return allNotificationSettings;
    }

    public List<UserCategoryBudget> getAllUserBudgets() {
        return allUserBudgets;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberOfFailedLogins(int numberOfFailedLogins) {
        this.numberOfFailedLogins = numberOfFailedLogins;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setAllExpenses(List<Expenses> allExpenses) {
        this.allExpenses = allExpenses;
    }

    public void setAllNotificationSettings(List<UserNotificationSetting> allNotificationSettings) {
        this.allNotificationSettings = allNotificationSettings;
    }

    public void setAllUserBudgets(List<UserCategoryBudget> allUserBudgets) {
        this.allUserBudgets = allUserBudgets;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }
}
