package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.Role;

public interface RoleDao {
    Role findByRole(String role);
}
