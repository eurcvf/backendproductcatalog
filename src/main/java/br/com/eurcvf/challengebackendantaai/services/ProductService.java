package br.com.eurcvf.challengebackendantaai.services;

import br.com.eurcvf.challengebackendantaai.domain.category.Category;
import br.com.eurcvf.challengebackendantaai.domain.category.CategoryDTO;
import br.com.eurcvf.challengebackendantaai.domain.category.exceptions.CategoryNotFoundException;
import br.com.eurcvf.challengebackendantaai.domain.product.Product;
import br.com.eurcvf.challengebackendantaai.domain.product.ProductDTO;
import br.com.eurcvf.challengebackendantaai.domain.product.exception.ProductNotFoundException;
import br.com.eurcvf.challengebackendantaai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private CategoryService categoryService;

    private ProductRepository productRepository;

    public void ProductRepository(CategoryService categoryService, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    public Product create(ProductDTO productDTO) {
        Category category = this.categoryService.listById(productDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);

        Product newProduct = new Product(productDTO);
        newProduct.setCategory(category);

        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> listAll() {
        return this.productRepository.findAll();
    }

    public Product update(String id, ProductDTO productDTO) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        if (productDTO.categoryId() != null) {
            this.categoryService.listById(productDTO.categoryId()).ifPresent(product::setCategory);
        }

        if (!productDTO.title().isEmpty()) product.setTitle(productDTO.title());
        if (!productDTO.description().isEmpty()) product.setDescription(productDTO.description());
        if (!(productDTO.price() == null)) product.setPrice(productDTO.price());

        this.productRepository.save(product);

        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        this.productRepository.delete(product);
    }

}
