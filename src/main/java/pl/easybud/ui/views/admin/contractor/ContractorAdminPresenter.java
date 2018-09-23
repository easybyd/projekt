package pl.easybud.ui.views.admin.contractor;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Contractor;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.backend.service.ContractorService;
import pl.easybud.backend.service.EmployeeService;
import pl.easybud.ui.navigation.NavigationManager;
import pl.easybud.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class ContractorAdminPresenter extends AbstractCrudPresenter<Contractor, ContractorService, ContractorAdminView> {

	@Autowired
	public ContractorAdminPresenter(ContractorAdminDataProvider contractorAdminDataProvider, NavigationManager navigationManager,
			ContractorService service, BeanFactory beanFactory) {
		super(navigationManager, service, Contractor.class, contractorAdminDataProvider, beanFactory);
	}
}
