package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.Campaign;
import com.dm_daddy.first_edition.Repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RepositoryRestController
@CrossOrigin
public class CampaignController {
    @Autowired
    private CampaignRepository repo;

    //---- Load All Campaigns -------
    //-------------------------------
   @GetMapping("/campaign/all")
    public List<Campaign> getAllCampaigns(){
        List<Campaign> campaignList = (List<Campaign>) repo.findAll();
        return campaignList;
    }
}
