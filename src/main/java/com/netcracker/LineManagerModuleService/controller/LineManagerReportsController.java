package com.netcracker.LineManagerModuleService.controller;

import com.netcracker.LineManagerModuleService.controller.exception.CandidateNotFoundException;
import com.netcracker.LineManagerModuleService.dao.Candidate;
import com.netcracker.LineManagerModuleService.dao.Demand;
import com.netcracker.LineManagerModuleService.service.CandidateDaoService;
import com.netcracker.LineManagerModuleService.service.OpenDemandDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LineManagerReportsController {
    @Autowired
    private OpenDemandDaoService openDemandDaoService;
    @Autowired
    private CandidateDaoService candidateDaoService;

    @GetMapping("/demands")
    public List<Demand> getOpenDemands() {
        return openDemandDaoService.getAllDemands();
    }

    @GetMapping("/candidates")
    public List<Candidate> getAvailableResources() {
        return candidateDaoService.getListOfAvailableCandidates();
    }

    @GetMapping("/candidates/{Id}")
    public Candidate getCandidateBydId(@PathVariable String Id) {
        Candidate candidate = candidateDaoService.getCandidateById(Id.toUpperCase());
        if(candidate == null) {
            throw new CandidateNotFoundException("Candidate with Id: "+Id+" is not found");
        }
        return candidate;
    }

    @PostMapping("/demands")
    public void createDemand(@Validated @RequestBody Demand demand) {
        openDemandDaoService.save(demand);
    }

    @PostMapping("/candidates")
    public ResponseEntity<Candidate> createCandidate(@Validated @RequestBody Candidate candidate) {
        candidateDaoService.save(candidate);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/demands/{Id}")
    public void deleteDemandById(@PathVariable String Id) {
        openDemandDaoService.deleteDemandById(Id.toUpperCase());
    }

    @DeleteMapping("/candidates/{Id}")
    public void deleteCandidateById(@PathVariable String Id) {
        candidateDaoService.deleteCandidateById(Id.toUpperCase());
    }

    /*@GetMapping("/candidates/match/{Id}")
    public Candidate getMatchedDemandWithCandidateId(@PathVariable String Id) {
        candidateDaoService.updateCandidateWithProfileMatch(Id.toUpperCase());
        Candidate candidateBydId = getCandidateBydId(Id.toUpperCase());
        return candidateBydId;
    }

    @GetMapping("/candidates/match")
    public List<Candidate> getMatchedDemandForAllCandidates() {
        for(Candidate candidate : CandidateDaoService.listOfCandidate) {
            candidateDaoService.updateCandidateWithProfileMatch(candidate.getId().toUpperCase());
        }
        return CandidateDaoService.listOfCandidate;
    }*/
}
