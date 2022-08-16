package pl.stamp222.restwebflux.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.stamp222.restwebflux.domain.Vendor;
import pl.stamp222.restwebflux.repository.CategoryRepository;
import pl.stamp222.restwebflux.repository.VendorRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final VendorRepository vendorRepository;
    private final CategoryRepository categoryRepository;

    public BootstrapData(VendorRepository vendorRepository, CategoryRepository categoryRepository) {
        this.vendorRepository = vendorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (vendorRepository.count().block() == 0) {
            loadVendors();
        }
    }

    private void loadVendors() {
        Vendor vendor1 = Vendor.builder().id("2").lastName("Jordan").firstName("Micheal").build();
        Vendor vendor2 = Vendor.builder().id("3").lastName("Szyper").firstName("Jacek").build();
        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(Vendor.builder().id("1").lastName("Jackson").firstName("Micheal").build());
    }
}
