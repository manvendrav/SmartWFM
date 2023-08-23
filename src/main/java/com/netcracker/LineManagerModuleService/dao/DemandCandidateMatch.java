package com.netcracker.LineManagerModuleService.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;

public class DemandCandidateMatch {
    @Id
    private String demandId;
    @JsonIgnore
    private String candidateId;
    private double matchPercentage;

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(double matchPercentage) {
        this.matchPercentage = matchPercentage;
    }
}
