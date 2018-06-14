package com.springapp.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(ModelMap model) {
	    return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/mainRedirect", method = RequestMethod.GET)
	public String chooseTable(ModelMap model, @RequestParam("table") String table) {
		switch(table){
			case "lecturer":
				return "indexLecturer";
			case "subject":
                return "indexSubject";
            case "schedule":
                return "indexPair";
            case "cabinet":
                return "indexCabinet";
            case "group":
                return "indexGroup";
            case "cell":
                return "indexCell";
			default:
				return "index";
		}
	}

	@RequestMapping("/mainCell")
	public String toMain(){
		return "mainCell";
	}

    @RequestMapping("/filterCell")
    public String toFilter(){
        return "filterCell";
    }

}