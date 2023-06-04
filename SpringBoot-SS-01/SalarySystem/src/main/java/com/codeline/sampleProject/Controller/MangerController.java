package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.RequestObjects.GetManagerRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetManagerResponse;
import com.codeline.sampleProject.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class MangerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("create")
    public void saveManager (@RequestBody GetManagerRequestObject managerRequestObject) {
        createManager(managerRequestObject);
    }

    @RequestMapping("get")
    public List<Manager> getManager () {
        return managerService.getManager();
    }

    //Path Variable
    @RequestMapping("get/{managerId}")
    public GetManagerResponse createManager (@PathVariable Long managerId) {
        return managerService.getManagerById(managerId);
    }

    public void createManager(GetManagerRequestObject managerRequestObject) {

        Manager manager = new Manager();
        manager.setDepartment(managerRequestObject.getDepartment());
        manager.setTeamName("The Moon");
        manager.setCreatedDate(new Date());
        manager.setIsActive(true);
        managerService.saveManager(manager);
    }

    @RequestMapping(value = "findManagerByTeamName", method = RequestMethod.GET)
    public Manager getManagerByTeamName(@RequestParam String teamName){
        return managerService.getManagerByTeamName(teamName);
    }
}
