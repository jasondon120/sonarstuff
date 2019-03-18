package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.HomebrewItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HomebrewItemRepository extends CrudRepository<HomebrewItems, Long> {

    @Query("select h from HomebrewItems h")
    public Page<HomebrewItems> getAllHomebrewItems(Pageable pageable);
}
