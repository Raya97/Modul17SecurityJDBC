package com.example.todolist.repository;



import com.example.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository is an interface for managing CRUD operations on the User entity.
 * It extends JpaRepository to provide standard methods for interacting with the "users" table in the database.
 *
 * JpaRepository provides various methods for CRUD operations and allows for the creation of custom query methods.
 * You can add custom query methods here if needed, such as finding users by specific criteria.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
