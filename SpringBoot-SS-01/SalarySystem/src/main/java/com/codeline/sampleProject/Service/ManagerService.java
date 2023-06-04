package com.codeline.sampleProject.Service;


import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.Repository.ManagerRepository;
import com.codeline.sampleProject.ResponseObjects.GetManagerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;
    public void saveManager(Manager manager){
        managerRepository.save(manager);
    }

    public List<Manager> getManager() {
        return managerRepository.findAll();
    }

    public GetManagerResponse getManagerById(Long managerId) {
        Optional<Manager> optionalManager =  managerRepository.findById(managerId);
        if(!optionalManager.isEmpty())
        {
            Manager manager =  optionalManager.get();
            GetManagerResponse managerResponse = new GetManagerResponse(manager.getTeamName(), manager.getDepartment());
            return managerResponse;
        }


        return null;

    }

    public Manager getManagerByTeamName(String nameOfTeam){
        return managerRepository.getManagerByTeamName(nameOfTeam);
    }

}
