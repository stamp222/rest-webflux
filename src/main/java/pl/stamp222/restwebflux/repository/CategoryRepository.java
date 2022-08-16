package pl.stamp222.restwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.stamp222.restwebflux.domain.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
    
}
