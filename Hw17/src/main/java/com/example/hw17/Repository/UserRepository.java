package com.example.hw17.Repository;

import com.example.hw17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByRole(String role);

    List<User> findByAge(Integer age);

    User findByUsername(String username);

    User findByEmail(String email);





}
