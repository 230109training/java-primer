package com.example.employeereimbursementsystemsb.daos;

import com.example.employeereimbursementsystemsb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public abstract Optional<User> findByEmail(String email);

    public abstract Optional<User> findByUsernameAndPassword(String username, String password);

}
