package com.dm_daddy.first_edition.Service;

import com.dm_daddy.first_edition.Model.PlayerCharacter;
import com.dm_daddy.first_edition.Repositories.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerCharacterService {
    @Autowired
    PlayerCharacterRepository repo;

    public List<PlayerCharacter> getPlayerCharacter(){
            return (List<PlayerCharacter>) repo.findAll();
    }

    public PlayerCharacter createPlayerCharacter(PlayerCharacter playerCharacter){
        return repo.save(playerCharacter);
    }
}
