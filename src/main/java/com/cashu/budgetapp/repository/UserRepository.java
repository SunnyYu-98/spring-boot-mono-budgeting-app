package com.cashu.budgetapp.repository;

import com.cashu.budgetapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//should probably change Integer to Long in the future
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
