package com.springapp.mvc.controller;

import com.springapp.mvc.database.Group;
import com.springapp.mvc.enums.Language;
import com.springapp.mvc.service.GroupService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.springapp.mvc.enums.Language.ROM;
import static com.springapp.mvc.enums.Language.RUS;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/getAll")
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

    @RequestMapping(value = "/add")
    public void addGroup(@ModelAttribute("group") Group group){
        groupService.addGroup(group);
    }

    @RequestMapping(value = "/update")
    public void updateGroup(@RequestParam("id") int id, @ModelAttribute("group") Group group){
        groupService.updateGroup(id, group);
    }
    @RequestMapping(value = "/delete")
    public void deleteGroup(@RequestParam("id") int id){
        groupService.deleteGroup(id);
    }
}
