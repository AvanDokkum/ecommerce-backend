package com.webcanis.backend;

import com.webcanis.backend.controllers.CategoryController;
import com.webcanis.backend.payload.CategoryDTO;
import com.webcanis.backend.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerUnitTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    void testCreateCategoryShouldPass() {
        // Arrange
        CategoryDTO inputDto = new CategoryDTO();
        inputDto.setCategoryName("TestCategory");

        CategoryDTO savedDto = new CategoryDTO();
        savedDto.setCategoryName("TestCategory");

        when(categoryService.createCategory(inputDto)).thenReturn(savedDto);

        // Act
        ResponseEntity<CategoryDTO> response = categoryController.createCategory(inputDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedDto, response.getBody());
        verify(categoryService).createCategory(inputDto);
    }
}
