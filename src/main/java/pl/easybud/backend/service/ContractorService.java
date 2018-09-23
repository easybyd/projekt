package pl.easybud.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.easybud.backend.data.entity.Contractor;
import pl.easybud.backend.repository.ContractorRepository;

import java.util.Optional;

@Service
public class ContractorService extends CrudService<Contractor> {

  private final ContractorRepository contractorRepository;

  @Autowired
  public ContractorService(ContractorRepository contractorRepository) {
    this.contractorRepository = contractorRepository;
  }

  @Override
  protected ContractorRepository getRepository() {
    return contractorRepository;
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
  public Page<Contractor> findAnyMatching(Optional<String> filter, Pageable pageable) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository().findByNameLikeIgnoreCase(repositoryFilter, pageable);
    } else {
      return getRepository().findAll(pageable);
    }
  }
}
