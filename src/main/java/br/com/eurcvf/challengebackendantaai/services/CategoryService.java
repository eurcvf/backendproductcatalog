package br.com.eurcvf.challengebackendantaai.services;

import br.com.eurcvf.challengebackendantaai.domain.category.Category;
import br.com.eurcvf.challengebackendantaai.domain.category.CategoryDTO;
import br.com.eurcvf.challengebackendantaai.domain.category.exceptions.CategoryNotFoundException;
import br.com.eurcvf.challengebackendantaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryDTO categoryDTO) {
        Category newCategory = new Category(categoryDTO);
        this.categoryRepository.save(newCategory);
        return newCategory;
    }

    public List<Category> listAll() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> listById(String id) {
        return this.categoryRepository.findById(id);
    }

    public Category update(String id, CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        if (!categoryDTO.title().isEmpty()) category.setTitle(categoryDTO.title());
        if (!categoryDTO.description().isEmpty()) category.setDescription(categoryDTO.description());

        this.categoryRepository.save(category);

        return category;
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        this.categoryRepository.delete(category);
    }
}
