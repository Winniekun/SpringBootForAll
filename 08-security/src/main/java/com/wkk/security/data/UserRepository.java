package com.wkk.security.data;

import com.wkk.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * TODO 类描述
 *
 * @author weikunkun
 * @since 2022/5/22
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUserName(String username);
}
