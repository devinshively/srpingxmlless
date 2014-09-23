package com.devin.next.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Picture {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String description;

  private Date dateTaken;

  @ManyToOne
  @JoinColumn (name="pet")
  private Pet pet;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDateTaken() {
    return dateTaken;
  }

  public void setDateTaken(Date dateTaken) {
    this.dateTaken = dateTaken;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

}
