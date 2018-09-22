package pl.easybud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.easybud.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
