package pl.easybud.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.easybud.backend.data.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  Page<Vehicle> findByNameLikeIgnoreCase(String name, Pageable page);

  int countByNameLikeIgnoreCase(String name);
}
