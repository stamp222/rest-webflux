package pl.stamp222.restwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.stamp222.restwebflux.domain.Category;
import pl.stamp222.restwebflux.domain.Vendor;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
    
}
