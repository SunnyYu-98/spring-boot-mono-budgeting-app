package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.model.UserNotificationSetting;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManager;

@Repository("UserEventDao")
public class UserEventsDao {

    EntityManager entityManager;


}