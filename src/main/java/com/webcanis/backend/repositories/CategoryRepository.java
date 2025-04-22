package com.webcanis.backend.repositories;

import com.webcanis.backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository //?no @Repository needed for this repository?
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
