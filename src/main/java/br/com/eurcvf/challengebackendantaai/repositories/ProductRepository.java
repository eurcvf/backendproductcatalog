package br.com.eurcvf.challengebackendantaai.repositories;

import br.com.eurcvf.challengebackendantaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
