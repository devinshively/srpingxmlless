package com.devin.next.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devin.next.dao.SnoutDao;
import com.devin.next.model.Owner;
import com.devin.next.model.Pet;

@Controller
public class SnoutContoller {
  
  @Autowired
  private SnoutDao dao;
  
  @RequestMapping("/owners")
  public String listOwners (Model model) {
    List<Owner> owners = dao.getOwners();    
    model.addAttribute("owners", owners);
    
    return "owners";
  }
  
  @RequestMapping("/pet/{petId}")  
  public String pet(@PathVariable Long petId, Model model) {
    Pet pet = dao.findPet(petId);
    model.addAttribute("pet", pet);
    
    return "viewPet";
  }
  
}
