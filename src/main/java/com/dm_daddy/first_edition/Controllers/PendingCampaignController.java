package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.Campaign;
import com.dm_daddy.first_edition.Model.PendingCampaign;
import com.dm_daddy.first_edition.Repositories.PendingCampaignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RepositoryRestController
@CrossOrigin
public class PendingCampaignController {
    @Autowired
    private PendingCampaignInterface repo;

    //--- Send Invite -----
    //--------------------
    @PostMapping("/invite")
    public PendingCampaign pendingCampaign(@RequestBody PendingCampaign pendingCampaign){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Calendar now = GregorianCalendar.getInstance();
        Timestamp createdDate = new Timestamp(now.getTimeInMillis());
        pendingCampaign.setDungeonMaster(currentPrincipalName);
        pendingCampaign.setRequestDate(createdDate);
        repo.save(pendingCampaign);
        return pendingCampaign;
    }

    //---Load Pending Request for Player ----
    //---------------------------------------


}
