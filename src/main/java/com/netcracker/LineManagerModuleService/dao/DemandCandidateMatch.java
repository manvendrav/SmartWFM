package com.netcracker.LineManagerModuleService.dao;

public class DemandCandidateMatch {

    private Demand demand;
    private Candidate candidate;
    private double matchPercentage;

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
