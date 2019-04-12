package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
}
