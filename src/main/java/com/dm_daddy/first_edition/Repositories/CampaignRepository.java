package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    List<Campaign> findCampaignById(Long id);

}
