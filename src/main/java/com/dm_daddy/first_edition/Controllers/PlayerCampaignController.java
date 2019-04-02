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
}
