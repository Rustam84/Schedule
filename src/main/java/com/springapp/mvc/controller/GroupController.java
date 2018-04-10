package com.springapp.mvc.controller;

import com.springapp.mvc.database.Group;
import com.springapp.mvc.enums.Language;
import com.springapp.mvc.service.GroupService;
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
    public void addGroup(@RequestParam("name") String name, @RequestParam("language") Language language, @RequestParam("numberOfStudents") int numberOfStudents){
        groupService.addGroup(new Group(name, language, numberOfStudents ));
    }

    @RequestMapping(value = "/update")
    public void updateGroup(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("language") Language language, @RequestParam("numberOfStudents") int numberOfStudents){
        groupService.updateGroup(id, new Group(name, language, numberOfStudents ));
    }
    @RequestMapping(value = "/delete")
    public void deleteGroup(@RequestParam("id") int id){
        groupService.deleteGroup(id);
    }
}
