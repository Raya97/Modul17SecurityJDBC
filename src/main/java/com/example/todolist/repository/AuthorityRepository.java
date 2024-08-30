package com.example.todolist.repository;

import com.example.todolist.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AuthorityRepository is an interface for managing CRUD operations on the Authority entity.
 * It extends JpaRepository to provide standard methods for interacting with the "authorities" table in the database.
 *
 * JpaRepository provides various methods for CRUD operations, and also allows for custom query methods to be defined.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
