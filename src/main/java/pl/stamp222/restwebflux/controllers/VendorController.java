package pl.stamp222.restwebflux.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.stamp222.restwebflux.domain.Vendor;
import pl.stamp222.restwebflux.repository.VendorRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class VendorController {

    private final VendorRepository vendorRepository;

    @GetMapping("/vendors")
    Flux<Vendor> getVendors() {
        return vendorRepository.findAll();
    }

    @GetMapping("/vendors/{vendorId}")
    Mono<Vendor> findById(@PathVariable String vendorId) {
        return vendorRepository.findById(vendorId);
    }
}
