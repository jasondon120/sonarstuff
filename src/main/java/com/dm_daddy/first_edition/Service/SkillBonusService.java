package com.dm_daddy.first_edition.Service;

import com.dm_daddy.first_edition.Model.PlayerCharacter;
import com.dm_daddy.first_edition.Model.SkillBonus;
import com.dm_daddy.first_edition.Repositories.PlayerCharacterRepository;
import com.dm_daddy.first_edition.Repositories.SkillBonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SkillBonusService {
    @Autowired
    SkillBonusRepository repo;

    @Autowired
    PlayerCharacterRepository pcRepo;

    public List<SkillBonus> getAllSkillBonus(){
        return (List<SkillBonus>) repo.findAll();
    }

    public Optional<SkillBonus> getSkillBonusById(Long id) {
        if(!repo.existsById(id)) {
            throw new ResourceNotFoundException("Unable to find");
        }
        return repo.findById(id);
    }

    public SkillBonus createSkillBonus(Long playerCharacterId, SkillBonus skillBonus) {
        List<SkillBonus> skillBonusList = new ArrayList<>();
        PlayerCharacter playerCharacter1 = new PlayerCharacter();

        Optional<PlayerCharacter>  byId = pcRepo.findById(playerCharacterId);
        if(!byId.isPresent()) {
            throw new ResourceNotFoundException("Author does not exist");
        }
        PlayerCharacter playerCharacter = byId.get();

        skillBonus.setPlayerCharacter(playerCharacter);

        SkillBonus skillBonus1 = repo.save(skillBonus);
        skillBonusList.add(skillBonus1);
        playerCharacter1.setSkillBonus(skillBonusList);

        return skillBonus1;
    }
}
