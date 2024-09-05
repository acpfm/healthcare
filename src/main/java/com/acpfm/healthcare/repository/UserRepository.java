package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUserName(String username);
    List<User> findByUsernameContaining(String username);
}
