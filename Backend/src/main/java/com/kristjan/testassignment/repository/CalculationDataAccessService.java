package com.kristjan.testassignment.repository;

import com.kristjan.testassignment.model.Calculation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationDataAccessService extends CrudRepository<Calculation, Integer> {}
