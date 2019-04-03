package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.PlayerCampaigns;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerCampaignRepository extends CrudRepository<PlayerCampaigns, Long> {

    List<PlayerCampaigns> findPlayerCampaignsByPlayerCharacterPlayerOrDungeonMasterContaining(String player, String dm);

    List<PlayerCampaigns> findPlayerCampaignsByCampaignIdAndPlayerCharacterIsNotNull(Long id);

}
