package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {
    public List<Whisky> findAllWhiskyByDistilleryIdAndAge(long distilleryId, int age);
    public List<Whisky> findAllWhiskyByDistilleryRegion(String region);
}
