package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<User> findUserByUsername(String searchCriteria);

//    @Query("select u.id from User u where u.username")
    List<User> findUsersIdByUsername(String name);
}
