package com.netcracker.LineManagerModuleService.service;

import com.netcracker.LineManagerModuleService.dao.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, String> {

    
}
