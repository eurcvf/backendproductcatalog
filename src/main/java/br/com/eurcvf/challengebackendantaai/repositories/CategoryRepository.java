package br.com.eurcvf.challengebackendantaai.repositories;

import br.com.eurcvf.challengebackendantaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
