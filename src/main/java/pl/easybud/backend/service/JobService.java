package pl.easybud.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.easybud.backend.data.entity.Job;
import pl.easybud.backend.repository.JobRepository;

import java.util.Optional;

@Service
public class JobService extends CrudService<Job> {

  private final JobRepository jobRepository;

  @Autowired
  public JobService(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  protected JobRepository getRepository() {
    return jobRepository;
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
  public Page<Job> findAnyMatching(Optional<String> filter, Pageable pageable) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository().findByNameLikeIgnoreCase(repositoryFilter, pageable);
    } else {
      return getRepository().findAll(pageable);
    }
  }
}
