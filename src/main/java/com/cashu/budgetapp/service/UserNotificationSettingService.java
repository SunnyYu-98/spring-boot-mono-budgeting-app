package com.cashu.budgetapp.service;

import com.cashu.budgetapp.model.UserNotificationSetting;
import com.cashu.budgetapp.dao.UserNotificationsDao;
import com.cashu.budgetapp.model.User;

import javax.annotation.Resource;

public class UserNotificationSettingService {

    @Resource(name = "UserNotificationDao")
    private UserNotificationsDao dao;

    public UserNotificationSetting getUserNotificationSettingByUser(User user){
        return dao.getUserNotificationSettingByUser(user);
    }
}
