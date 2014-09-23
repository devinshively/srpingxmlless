package com.devin.next.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devin.next.model.Owner;
import com.devin.next.model.Pet;

@Repository
@Transactional
public class SnoutDao {
  
  @PersistenceContext
  private EntityManager entityManager;

  public List<Owner> getOwners() {    
    return entityManager.createQuery(
        "select o from com.devin.next.model.Owner o", Owner.class)
        .getResultList();
  }
  

  public Owner findOwner(Long id) {
    return entityManager.find(Owner.class, id);
  }
  
  public void saveOwner(Owner o) {
    entityManager.persist(o);      
  }
  
  
  public Pet findPet(Long petId) {
    return entityManager.find(Pet.class, petId);
  }

  public void savePet(Pet pet) {       
    entityManager.persist(pet);    
  }
  
  
  
}
