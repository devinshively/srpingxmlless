package com.devin.next.controllers;

import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.support.SessionStatus;

import com.devin.next.dao.SnoutDao;
import com.devin.next.form.PetForm;
import com.devin.next.model.Owner;
import com.devin.next.model.Pet;


@Controller
@RequestMapping("/addPet")
public class AddPetForm {

  @Autowired
  private SnoutDao dao;  
  
  @RequestMapping(method = RequestMethod.GET)
  public String setupForm(Model model) {
    Pet pet = new Pet();
    model.addAttribute("pet", pet);
    
    PetForm form = new PetForm();       
    model.addAttribute("petForm", form);    
    return "addPet";
  }

  
  @ModelAttribute("owners")
  public Collection<Owner> getOwners(){
    return dao.getOwners();
  }
  
  @ModelAttribute("monthNames")
  public Collection<Month> getMonthNames() {
    String[] names = new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
    List<Month> answer = new ArrayList<Month>();
    for (int i=0; i<names.length; i++) {
      answer.add(new Month(i, names[i]));
    }
    
    return answer;
  }
  
 
  
  @RequestMapping(method = RequestMethod.POST)
  public String handleSubmit(@Valid PetForm form, BindingResult result, SessionStatus status) {
    
    form.validate(result);
    
    if (result.hasErrors()) {      
      return "addPet";
    }
    else {      
      Pet pet = new Pet();
      pet.setName(form.getName());
      Calendar cal = new GregorianCalendar(form.getYearBorn(), form.getMonthBorn(), form.getDayBorn());
      pet.setDateBorn(cal.getTime());
      pet.setAlive(form.isAlive()); 
      Owner o = dao.findOwner(form.getOwner());      
      pet.setOwner(o);      
      dao.savePet(pet);
      status.setComplete();
      
      return "redirect:owners";    
    }
    
  }
  
  
  
  class Month {
    private int id;
    private String label;
    
    public Month(int id, String label) {
      this.id=id;
      this.label = label;
    }
    
    public int getId() {
      return id;
    }
    public void setId(int id) {
      this.id = id;
    }
    public String getLabel() {
      return label;
    }
    public void setLabel(String label) {
      this.label = label;
    }
  }
  
  
}
