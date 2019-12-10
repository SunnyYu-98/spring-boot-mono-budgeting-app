package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.model.UserNotificationSetting;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManager;

@Repository("UserNotificationsDao")
public class UserNotificationsDao {

    EntityManager entityManager;

    public UserNotificationSetting getUserNotificationSettingByUser(User user){
        Query query = entityManager.createNativeQuery("SELECT * FROM user_notification_setting WHERE user_id = ?", UserNotificationSetting.class);
        query.setParameter(1, user.getUserId());
        List<UserNotificationSetting> setting = query.getResultList();
        return setting.isEmpty() ? null : setting.get(0);
    }

    public void deleteSettingByUserId(int id){
        Query query = entityManager.createNativeQuery(" delete from user_notification_setting where user_id = ?", UserNotificationSetting.class);
        query.setParameter(1, id);
    }

    public void saveNotificationSetting(UserNotificationSetting setting){
        entityManager.persist(setting);
    }
}