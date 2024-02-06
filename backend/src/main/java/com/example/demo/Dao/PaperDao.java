package com.example.demo.Dao;

import java.util.List;

import com.example.demo.model.Paper;
/**
 *  PaperDao interface providing data access operations for Paper entities.
 */
public interface PaperDao {
    List<Paper>findAll();
}
