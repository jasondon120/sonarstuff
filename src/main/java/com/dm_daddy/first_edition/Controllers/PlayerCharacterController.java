package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.*;
import com.dm_daddy.first_edition.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RepositoryRestController
@CrossOrigin
public class PlayerCharacterController {

    @Autowired
    private PlayerCharacterRepository repo;

    @Autowired
    private RefCodeRepository refRepo;

    @Autowired
    private PlayerCampaignRepository campRepo;

    @Autowired
    private RaceRepository raceRepo;

    @Autowired
    private SkillBonusRepository skillRepo;

    @Autowired
    private BackgroundRepository bgRepo;

    @Autowired
    private RacialFeaturesRepository rfRepo;
    //------ Load Characters By Creator ----
    //-------------------------------------
    @GetMapping("/profile/{player}/characters")
    public List<PlayerCharacter>  getCharacterByCreator(@PathVariable String player){
//    List<PlayerCharacter> characterList = repo.findPlayerCharacterByPlayerContaining(player);
    List<PlayerCharacter> characterList = repo.findPlayerCharacterByCreatorIdUsername(player);
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
        List<PlayerCharacter> charList = repo.findPlayerCharacterByCreatorIdUsernameContainingAndCampIdIsNull(player);
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
    public List<Backgrounds> getBackground(){
        List<Backgrounds> backgroundList = (List<Backgrounds>) bgRepo.findAll();
        return backgroundList;
    }


    //---- Load Races -----
    //---------------------
    @GetMapping("/races")
    public List<Race> getRaces(){
        List<Race> raceList = (List<Race>) raceRepo.findAll();
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

    //--- Load Skill by Class Name ----
    //---------------------------------
    @GetMapping("/skills/{classname}")
    public List<RefCode> getSkillByName(@PathVariable String classname){
        List<RefCode> skillList = (List<RefCode>) refRepo.findRefCodeByDescriptionContaining(classname);
        return skillList;
    }

    //---- Create a character ----
    //----------------------------
    @RequestMapping(value="/character/create")
    @PostMapping
    @Transactional
    public PlayerCharacter createCharacter(@RequestBody PlayerCharacter playerCharacter){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        playerCharacter.setPlayer(currentPrincipalName);
        if(playerCharacter.getSkillBonus() != null){
            for(SkillBonus bonus: playerCharacter.getSkillBonus()) {
                bonus.setPlayerCharacter(playerCharacter);


            }
        }
        PlayerCharacter createCharacter = repo.save(playerCharacter);
        return createCharacter;
    }



    //---- Delete a character ---
    //---------------------------
    @RequestMapping(value = "/character/delete/{id}", method = RequestMethod.DELETE)
    @Transactional
    public List<PlayerCharacter> deleteCharacter(@PathVariable Long id){
        PlayerCampaigns pc = campRepo.findPlayerCampaignsByPlayerCharacterId(id);
        if(pc != null){
            campRepo.deleteById(pc.getId());
        }
        repo.deleteById(id);
        List<PlayerCharacter> playerList = (List<PlayerCharacter>) repo.findAll();
        return playerList;
    }

    //---- Load Proficient Skills by Player Character Id ---------
    //------------------------------------------------------------
    @GetMapping("/character/proficiency-skills/{id}")
    public List<SkillBonus> getAllSkillProf(@PathVariable Long id){
        List<SkillBonus> skillBonusList = (List<SkillBonus>) skillRepo.findSkillBonusByPlayerCharacterId(id);
        return skillBonusList;
    }

    //---- Load all Proficiency by Creator Id ----
    //-----------------------------------------
    @GetMapping("/all-characters/{username}")
    public List<SkillBonus> getSkillByCreatorId(@PathVariable String username) {
        List<SkillBonus> skillBonusList = (List<SkillBonus>) skillRepo.findSkillBonusByPlayerCharacterCreatorIdUsername(username);
        return skillBonusList;
    }

    //---- Load all Proficiency by Campaign Id ---
    //--------------------------------------------
    @GetMapping("/campaign/character-skills/{id}")
    public List<SkillBonus> getSkillByCampId(@PathVariable Long id) {
        List<SkillBonus> skillBonusList = (List<SkillBonus>) skillRepo.findSkillBonusByPlayerCharacterCampIdId(id);
        return skillBonusList;
    }

    //---- Load Racial Features By Race Id -----
    //------------------------------------------
    @GetMapping("/race/feature/{id}")
    public List<RacialFeatures> getRaceFeatureByRaceId(@PathVariable Long id) {
        List<RacialFeatures> racialFeaturesList = (List<RacialFeatures>) rfRepo.findRacialFeaturesByRaceId(id);
        return racialFeaturesList;
    }

    //---- Load Racial Features -----
    //------------------------------
    @GetMapping("race/feature")
    public List<RacialFeatures> getRacialFeatures(){
        List<RacialFeatures> racialFeaturesList = (List<RacialFeatures>) rfRepo.findAll();
        return racialFeaturesList;
    }
}


