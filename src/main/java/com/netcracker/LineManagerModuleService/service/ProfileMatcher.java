package com.netcracker.LineManagerModuleService.service;

import com.netcracker.LineManagerModuleService.dao.Candidate;
import com.netcracker.LineManagerModuleService.dao.Demand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileMatcher {

    public double getResourceToDemandMatchPercentage(Candidate candidate, Demand demand) {
        return calculateMatchingPercentage(candidate, demand);
    }

    public double calculateMatchingPercentage(Candidate candidate, Demand demand) {
        List<String> candidateSkills = candidate.getSkillSet();
        int candidateExperience = candidate.getYearsOfExperience();

        List<String> requiredSkills = demand.getDesiredSkillSet();
        int requiredExperience = demand.getDesiredYearsOfExperience();
        double skillMatchPercentage = (double) countMatchingSkills(candidateSkills, requiredSkills) / requiredSkills.size() * 100;
        double experienceMatchPercentage = (double) candidateExperience / requiredExperience * 100;
        double overallMatchingPercentage = (skillMatchPercentage + experienceMatchPercentage) / 2;

        return overallMatchingPercentage;
    }

    public int countMatchingSkills(List<String> candidateSkills, List<String> desiredSkills) {
        int count = 0;
        for (String skill : desiredSkills) {
            if (candidateSkills.contains(skill)) {
                count++;
            }
        }
        return count;
    }
}
