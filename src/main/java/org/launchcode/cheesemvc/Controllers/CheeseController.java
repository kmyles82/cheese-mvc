package org.launchcode.cheesemvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    //Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "List of my cheese");

        return "cheese/index";
    }

    //form display
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    //process the form
    public String processCheeseForm(@RequestParam String cheeseName){
        cheeses.add(cheeseName);

        //redirect to /cheese
        return "redirect:";
    }
}
