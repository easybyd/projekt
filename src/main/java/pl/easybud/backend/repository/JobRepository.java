package pl.easybud.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.easybud.backend.data.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

  Page<Job> findByNameLikeIgnoreCase(String name, Pageable page);

  int countByNameLikeIgnoreCase(String name);
}
