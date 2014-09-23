package com.devin.next.form;

import java.util.*;
import org.hibernate.validator.constraints.*;
import org.springframework.validation.Errors;


public class PetForm {
    
  @NotEmpty
  @Length(min=1, max=32)
  private String name="breakfast";  

  @Range(min=1, max=31)
  private int dayBorn=1;
  
  @Range(min=0, max=11)
  private int monthBorn=0;
  
  @Range(min=1900, max=2038)
  private int yearBorn=1990;
  
  private Date dateBorn;
  
  private boolean alive=true;
    
  private long owner;
  
  
  public void validate (Errors errors) {
    Calendar cal = new GregorianCalendar(yearBorn, monthBorn, dayBorn);
    dateBorn = cal.getTime();
    if (dateBorn.after(new Date())) {
      errors.rejectValue("dateBorn", null, "Date is in future");
    }    
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
  public long getOwner() {
    return owner;
  }
  public void setOwner(long owner) {
    this.owner = owner;
  }   
  public int getDayBorn() {
    return dayBorn;
  }
  public void setDayBorn(int dayBorn) {
    this.dayBorn = dayBorn;
  }
  public int getMonthBorn() {
    return monthBorn;
  }
  public void setMonthBorn(int monthBorn) {
    this.monthBorn = monthBorn;
  }
  public int getYearBorn() {
    return yearBorn;
  }
  public void setYearBorn(int yearBorn) {
    this.yearBorn = yearBorn;
  }
  
  @Override
  public String toString() {
    return String.format("PetForm{name=%s, owner=%s, monthBorn=%d}", name, owner, monthBorn);
  }
  
}
