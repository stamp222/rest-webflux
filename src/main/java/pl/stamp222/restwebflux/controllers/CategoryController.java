package pl.stamp222.restwebflux.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.stamp222.restwebflux.domain.Category;
import pl.stamp222.restwebflux.repository.CategoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("categories")
    Flux<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("categories/{categoryId}")
    Mono<Category> findById(@PathVariable String categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
