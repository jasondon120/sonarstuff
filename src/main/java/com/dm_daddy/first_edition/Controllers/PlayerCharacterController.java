package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.PlayerCharacter;
import com.dm_daddy.first_edition.Model.RefCode;
import com.dm_daddy.first_edition.Repositories.PlayerCharacterRepository;
import com.dm_daddy.first_edition.Repositories.RefCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RepositoryRestController
@CrossOrigin
public class PlayerCharacterController {

    @Autowired
    private PlayerCharacterRepository repo;

    @Autowired
    private RefCodeRepository refRepo;

    //------ Load Characters By Creator ----
    //-------------------------------------
    @GetMapping("/profile/{player}/characters")
    public List<PlayerCharacter>  getCharacterByCreator(@PathVariable String player){
    List<PlayerCharacter> characterList = repo.findPlayerCharacterByPlayerContaining(player);
    return characterList;
    }

    //---- Load Character By Id ------
    //--------------------------------
    @GetMapping("/character/{id}")
    public List<PlayerCharacter> getCharacterById(@PathVariable Long id){
        List<PlayerCharacter> character = repo.findPlayerCharacterById(id);
        return character;
    }

    //--- Load Character By Creator and Camp_Id is null ------
    //--------------------------------------------------------
    @GetMapping("/character/user/{player}")
    public List<PlayerCharacter> getChar(@PathVariable String player){
        List<PlayerCharacter> charList = repo.findPlayerCharacterByPlayerContainingAndCampIdIsNull(player);
        return charList;
    }

    //----- Load alignment ------
    //---------------------------
    @GetMapping("/alignment")
    public List<RefCode> getAlignment(){
        List<RefCode> alignmentList = (List<RefCode>) refRepo.findByParentId((long) 124);
        return alignmentList;
    }

    //---- Load Background -----
    //--------------------------
    @GetMapping("/background")
    public List<RefCode> getBackground(){
        List<RefCode> backgroundList = (List<RefCode>) refRepo.findByParentId((long) 117);
        return backgroundList;
    }


    //---- Load Races -----
    //---------------------
    @GetMapping("/races")
    public List<RefCode> getRaces(){
        List<RefCode> raceList = (List<RefCode>) refRepo.findByParentId((long) 94);
        return raceList;
    }

    //--- Load Classes -----
    //----------------------
    @GetMapping("/classes")
    public List<RefCode> getClasses(){
        List<RefCode> classList = (List<RefCode>) refRepo.findByParentId((long) 104);
        return classList;
    }

    @GetMapping("/abilities")
    //-- Load Abilities ----
    //----------------------
    public List<RefCode> getAbilities(){
        List<RefCode> abilityList = (List<RefCode>) refRepo.findByParentId((long) 134);
        return abilityList;
    }
    @GetMapping("skills")
    //-- Load Skills -----
    //--------------------
    public List<RefCode> getSkills(){
        List<RefCode> skillList = (List<RefCode>) refRepo.findByParentId((long) 141);
        return skillList;
    }

    //---- Create a character ----
    //----------------------------
    @RequestMapping(value="/character/create")
    @PostMapping
    public PlayerCharacter createCharacter(@RequestBody PlayerCharacter playerCharacter){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        playerCharacter.setPlayer(currentPrincipalName);
        PlayerCharacter createCharacter = repo.save(playerCharacter);
        return createCharacter;
    }


}
