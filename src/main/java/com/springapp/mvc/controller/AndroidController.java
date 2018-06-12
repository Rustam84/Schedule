package com.springapp.mvc.controller;

import com.springapp.mvc.database.Group;
import com.springapp.mvc.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/android")
public class AndroidController {
    private GroupService groupService;

    public AndroidController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/getAllGroups")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}
