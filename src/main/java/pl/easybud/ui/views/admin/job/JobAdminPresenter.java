package pl.easybud.ui.views.admin.job;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Job;
import pl.easybud.backend.service.JobService;
import pl.easybud.ui.navigation.NavigationManager;
import pl.easybud.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class JobAdminPresenter extends AbstractCrudPresenter<Job, JobService, JobAdminView> {

  @Autowired
  public JobAdminPresenter(JobAdminDataProvider jobAdminDataProvider, NavigationManager navigationManager,
      JobService service, BeanFactory beanFactory) {
    super(navigationManager, service, Job.class, jobAdminDataProvider, beanFactory);
  }
}
