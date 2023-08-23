package com.netcracker.LineManagerModuleService.service;

import com.netcracker.LineManagerModuleService.dao.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, String> {


}
