package com.example.demo.Dao;

import java.util.List;
import com.example.demo.model.Paper;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class PaperDaoImp implements PaperDao {

   private final EntityManager entityManager;

   public PaperDaoImp(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   @Override
   public List<Paper> findAll() {
      TypedQuery<Paper> query = entityManager.createQuery("from Paper", Paper.class);
      return query.getResultList();
   }

   @Override
   public List<Paper> findStatus(String status) {
      TypedQuery<Paper> query = entityManager.createQuery(String.format("from Paper WHERE status=%s",status), Paper.class);
      return query.getResultList();
   }
}

