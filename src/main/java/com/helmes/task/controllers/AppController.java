package com.helmes.task.controllers;

import com.helmes.task.entities.Sector;
import com.helmes.task.entities.User;
import com.helmes.task.services.SectorService;
import com.helmes.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private final SectorService sectorService;
    private final UserService userService;

    @Autowired
    public AppController(SectorService sectorService, UserService userService) {
        this.sectorService = sectorService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("sectors",sectorService.findAllSectors());
        if (userService.findAllUsers().size() < 1){
            model.addAttribute("user",new User("",new ArrayList<Integer>(),false));
        }else{
            model.addAttribute("user", userService.findAllUsers().get(0));
        }
        model.addAttribute("users", userService.findAllUsers());

        return "index";
    }

    @RequestMapping(value = "/sector", method = RequestMethod.POST)
    public String saveToDb(@RequestBody String body){
        sectorService.addSectorsToDb(body);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String receiveToSave(@RequestParam(value = "name_input") String name, @RequestParam(value = "existing_sectors", required = false) List<Integer> sectors, @RequestParam(value = "db_sectors", required = false) List<Integer> dbSectors, @RequestParam(value = "agreement_input") boolean agreed ){
        if(sectors==null){
            userService.changeUserData(name, dbSectors, agreed);
        }else{
            userService.addUserData(name, sectors, agreed);
        }
        return "redirect:/";
    }
}
