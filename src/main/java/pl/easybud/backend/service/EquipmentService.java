package pl.easybud.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.easybud.backend.repository.EquipmentRepository;
import pl.easybud.backend.data.entity.Equipment;

import java.util.Optional;

@Service
public class EquipmentService extends CrudService<Equipment> {

  private final EquipmentRepository equipmentRepository;

  @Autowired
  public EquipmentService(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
  }

  @Override
  protected EquipmentRepository getRepository() {
    return equipmentRepository;
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
  public Page<Equipment> findAnyMatching(Optional<String> filter, Pageable pageable) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository().findByNameLikeIgnoreCase(repositoryFilter, pageable);
    } else {
      return getRepository().findAll(pageable);
    }
  }
}
