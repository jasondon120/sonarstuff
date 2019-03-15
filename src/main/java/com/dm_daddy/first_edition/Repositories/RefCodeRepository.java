package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.RefCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RefCodeRepository extends CrudRepository<RefCode, Long> {

    List<RefCode> findByParentId(@Param("parentId") Long id);
}
