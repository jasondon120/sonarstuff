package com.dm_daddy.first_edition.Repositories;

import com.dm_daddy.first_edition.Model.RacialFeatures;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RacialFeaturesRepository extends CrudRepository<RacialFeatures, Long> {
    List<RacialFeatures> findRacialFeaturesByRaceId(Long id);
}
