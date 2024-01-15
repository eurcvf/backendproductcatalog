package br.com.eurcvf.challengebackendantaai.controllers;

import br.com.eurcvf.challengebackendantaai.domain.product.Product;
import br.com.eurcvf.challengebackendantaai.domain.product.ProductDTO;
import br.com.eurcvf.challengebackendantaai.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        Product newProduct = this.productService.create(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listAll() {
        List<Product> products = this.productService.listAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = this.productService.update(id, productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
