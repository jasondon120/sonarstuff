package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Items, Long> {



}
