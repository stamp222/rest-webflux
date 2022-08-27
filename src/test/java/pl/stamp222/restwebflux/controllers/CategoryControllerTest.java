package pl.stamp222.restwebflux.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.stamp222.restwebflux.domain.Category;
import pl.stamp222.restwebflux.repository.CategoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


class CategoryControllerTest {

    CategoryController categoryController;
    CategoryRepository categoryRepository;
    WebTestClient testWebClient;

    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryController = new CategoryController(categoryRepository);
        testWebClient = WebTestClient.bindToController(categoryController).build();
    }

    @Test
    void getCategories() {
        BDDMockito.given(categoryRepository.findAll()).willReturn(
                Flux.just(Category.builder().description("Cat1").build(),
                        Category.builder().description("Cat2").build())
        );

        testWebClient.get().uri("/api/v1/categories/")
                .exchange()
                .expectBodyList(Category.class)
                .hasSize(2);
    }

    @Test
    void findById() {

        BDDMockito.given(categoryRepository.findById("any(String.class)")).willReturn(
                Mono.just(Category.builder().description("Cat1").build())
        );

        testWebClient.get().uri("/api/v1/categories/1")
                .exchange()
                .expectBody(Category.class);

    }
}