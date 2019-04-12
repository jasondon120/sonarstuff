package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.SkillBonus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillBonusRepository extends CrudRepository<SkillBonus, Long> {
    List<SkillBonus> findSkillBonusByPlayerCharacterId(Long id);

    List<SkillBonus> findSkillBonusByPlayerCharacterCreatorIdUsername(String username);

    List<SkillBonus> findSkillBonusByPlayerCharacterCampIdId(Long id);
}
