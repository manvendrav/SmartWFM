package com.netcracker.LineManagerModuleService.service;

import com.netcracker.LineManagerModuleService.controller.exception.DemandNotFoundException;
import com.netcracker.LineManagerModuleService.dao.Candidate;
import com.netcracker.LineManagerModuleService.dao.Demand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class OpenDemandDaoService {

    // // for testing purpose lets create a static arraylist of open demand

    public static List<Demand> listOfDemands = new ArrayList<>();

    static {
        Demand demand1 = new Demand("332xxd3", "DT", Arrays.asList("Java", "OPF"),
                4, "OPF", "Germany", "India");
        Demand demand2 = new Demand("43f2sc", "DU", Arrays.asList("CPQ", "OPF"),
                2, "OPF", "UAE", "India");
        Demand demand3 = new Demand("4334fc2wd2", "NUDAY",
                Arrays.asList("Java", "OPF", "SpringBoot"), 8, "OPF", "France",
                "CIS");
        listOfDemands.add(demand1);
        listOfDemands.add(demand2);
        listOfDemands.add(demand3);
    }

    // TODO find all the open demands
    public List<Demand> getAllDemands() {
        return listOfDemands;
    }

    public void save(Demand demand) {
        listOfDemands.add(demand);
    }

    public void deleteDemandById(String Id) {
        Demand demand = listOfDemands.stream().filter(e -> e.getId().equals(Id)).findFirst().orElse(null);
        if (demand == null) {
            throw new DemandNotFoundException("Demand with demand Id:" + Id + " does not exist");
        }
        listOfDemands.remove(demand);
    }

    // TODO to save the open demand in the DB

    // TODO to delete the open demand from the DB
}
