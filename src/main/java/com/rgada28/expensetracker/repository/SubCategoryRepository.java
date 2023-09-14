package com.rgada28.expensetracker.repository;

import com.rgada28.expensetracker.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
}
