package com.example.demo.Dao;

import java.util.List;
import com.example.demo.model.Paper;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * Implementation of the PaperDao interface providing data access operations for Paper entities.
 */
@Repository
public class PaperDaoImp implements PaperDao {

   private final EntityManager entityManager;
   /**
    * Constructs a new PaperDaoImp with the specified EntityManager dependency.
    *
    * @param entityManager The EntityManager used for interacting with the database.
    */

   public PaperDaoImp(EntityManager entityManager) {
      this.entityManager = entityManager;
   }
   /**
    * Retrieves a list of all papers available in the database.
    *
    * @return A list of Paper objects representing papers stored in the database.
    */
   @Override
   public List<Paper> findAll() {
      TypedQuery<Paper> query = entityManager.createQuery("from Paper", Paper.class);
      return query.getResultList();
   }
}

