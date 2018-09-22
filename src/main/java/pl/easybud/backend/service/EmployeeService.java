package pl.easybud.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pl.easybud.backend.EmployeeRepository;
import pl.easybud.backend.data.entity.Employee;

import java.util.Optional;

@Service
public class EmployeeService extends CrudService<Employee> {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  protected EmployeeRepository getRepository() {
    return employeeRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository().countByNameLikeIgnoreCase(repositoryFilter);
    } else {
      return getRepository().count();
    }
  }

  @Override
  public Page<Employee> findAnyMatching(Optional<String> filter, Pageable pageable) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository().findByNameLikeIgnoreCase(repositoryFilter, pageable);
    } else {
      return getRepository().findAll(pageable);
    }
  }
}
