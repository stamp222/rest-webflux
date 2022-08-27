package pl.stamp222.restwebflux.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.stamp222.restwebflux.domain.Vendor;
import pl.stamp222.restwebflux.repository.VendorRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class VendorControllerTest {
    VendorController vendorController;
    VendorRepository vendorRepository;
    WebTestClient testWebClient;

    @BeforeEach
    void setUp() {
        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        testWebClient = WebTestClient.bindToController(vendorController).build();

    }

    @Test
    void getVendors() {
        BDDMockito.given(vendorRepository.findAll()).willReturn(
                Flux.just(Vendor.builder().firstName("Jacek").lastName("Szyper").build(),
                        Vendor.builder().firstName("Magda").lastName("Ptasik").build())
        );

        testWebClient.get().uri("/api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    void findById() {
        BDDMockito.given(vendorRepository.findById("any(String.class)")).willReturn(
                Mono.just(Vendor.builder().firstName("Jacek").lastName("Szyper").build())
        );

        testWebClient.get().uri("/api/v1/vendors/1")
                .exchange()
                .expectBody(Vendor.class);
    }
}