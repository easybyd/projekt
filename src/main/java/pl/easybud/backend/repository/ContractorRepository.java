package pl.easybud.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.easybud.backend.data.entity.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {

  Page<Contractor> findByNameLikeIgnoreCase(String name, Pageable page);

  int countByNameLikeIgnoreCase(String name);

}
