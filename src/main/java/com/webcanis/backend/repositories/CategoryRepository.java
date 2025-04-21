package com.webcanis.backend.repositories;

import com.webcanis.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository //?no @Repository needed for this repository?
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
