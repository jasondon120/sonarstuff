package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.Role;
import com.dm_daddy.first_edition.Model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
