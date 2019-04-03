package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.PlayerCampaigns;
import com.dm_daddy.first_edition.Repositories.PlayerCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RepositoryRestController
@CrossOrigin
public class PlayerCampaignController {
    @Autowired
    private PlayerCampaignRepository repo;

    //------ Load Campaign by Player ----
    //-------------------------------------
    @GetMapping("campaign/{player}/{dm}")
    public List<PlayerCampaigns> getCampaignByPlayer(@PathVariable String player, @PathVariable String dm){
        List<PlayerCampaigns> campaignsList = repo.findPlayerCampaignsByPlayerCharacterPlayerOrDungeonMasterContaining(player,dm);
        return campaignsList;
    }

    //------Load Campaign By Id -----
    //-------------------------------
    @GetMapping("campaign/{id}")
    public List<PlayerCampaigns> getCampaignById(@PathVariable Long id){
        List<PlayerCampaigns> playerList = repo.findPlayerCampaignsByCampaignIdAndPlayerCharacterIsNotNull(id);
        return playerList;
    }

}
