package com.devin.next.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {

  @Id
  @GeneratedValue  
  private Long id;

  private String name;

  @OneToMany (cascade=CascadeType.ALL, mappedBy="owner")
  private List<Pet> pets;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }
  
  public String[] getPetNames() {
    List<String> names = new ArrayList<String>();
    for (Pet p : getPets()) {
      names.add(p.getName());
    }
    return names.toArray(new String[0]);
  }

}
