package pl.easybud.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.easybud.backend.data.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  Page<Employee> findByNameLikeIgnoreCase(String name, Pageable page);

  int countByNameLikeIgnoreCase(String name);

}
