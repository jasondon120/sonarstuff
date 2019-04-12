package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.PlayerCharacter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, Long> {


//    List<PlayerCharacter> findPlayerCharacterByPlayerContaining(String player);

    List<PlayerCharacter> findPlayerCharacterByCreatorIdUsername(String player);

    List<PlayerCharacter> findPlayerCharacterByCreatorIdUsernameContainingAndCampIdIsNull(String player);

    List<PlayerCharacter> findPlayerCharacterById(Long id);

}
