package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.Dm_Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dmUsersRepository extends CrudRepository<Dm_Users, Long> {
}
