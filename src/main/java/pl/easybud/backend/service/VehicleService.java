package pl.easybud.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.easybud.backend.repository.VehicleRepository;
import pl.easybud.backend.data.entity.Vehicle;

import java.util.Optional;

@Service
public class VehicleService extends CrudService<Vehicle> {

  private final VehicleRepository vehicleRepository;

  @Autowired
  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  protected VehicleRepository getRepository() {
    return vehicleRepository;
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
  public Page<Vehicle> findAnyMatching(Optional<String> filter, Pageable pageable) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository().findByNameLikeIgnoreCase(repositoryFilter, pageable);
    } else {
      return getRepository().findAll(pageable);
    }
  }
}