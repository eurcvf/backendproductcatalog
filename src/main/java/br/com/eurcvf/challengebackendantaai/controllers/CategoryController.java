package br.com.eurcvf.challengebackendantaai.controllers;

import br.com.eurcvf.challengebackendantaai.domain.category.Category;
import br.com.eurcvf.challengebackendantaai.domain.category.CategoryDTO;
import br.com.eurcvf.challengebackendantaai.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO) {
        Category newCategory = this.categoryService.create(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> listAll() {
        List<Category> categories = this.categoryService.listAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CategoryDTO categoryDTO) {
        Category updatedCategory = this.categoryService.update(id, categoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") String id) {
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
