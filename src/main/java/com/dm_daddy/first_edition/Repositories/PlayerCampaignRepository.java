package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.PlayerCampaigns;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerCampaignRepository extends CrudRepository<PlayerCampaigns, Long> {

    List<PlayerCampaigns> findPlayerCampaignsByPlayerCharacterCreatorIdUsernameOrCreatorIdUsername(String player, String dm);

    List<PlayerCampaigns> findPlayerCampaignsByCampaignIdAndPlayerCharacterIsNotNull(Long id);

    PlayerCampaigns findPlayerCampaignsByPlayerCharacterId(Long id);

    PlayerCampaigns deletePlayerCampaignsById(PlayerCampaigns id);

    List<PlayerCampaigns> deletePlayerCampaignsByPlayerCharacterId(Long id);

    List<PlayerCampaigns> deletePlayerCampaignsByCampaignId(Long id);

}
