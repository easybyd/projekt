package pl.easybud.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.easybud.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
