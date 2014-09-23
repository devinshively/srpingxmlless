package com.devin.next.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Pet {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private Date dateBorn;  
  private boolean alive;

  @ManyToOne
  @JoinColumn(name="owner")
  private Owner owner;

  @OneToMany (mappedBy="pet")  
  private List<Picture> pics;

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

  public Date getDateBorn() {
    return dateBorn;
  }

  public void setDateBorn(Date dateBorn) {
    this.dateBorn = dateBorn;
  }

  public boolean isAlive() {
    return alive;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public List<Picture> getPics() {
    return pics;
  }

  public void setPics(List<Picture> pics) {
    this.pics = pics;
  }
  
}
