package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.PendingCampaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingCampaignInterface extends CrudRepository<PendingCampaign, Long> {
}
