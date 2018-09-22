package pl.easybud.ui.views.admin.employee;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.backend.service.EmployeeService;
import pl.easybud.ui.navigation.NavigationManager;
import pl.easybud.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class EmployeeAdminPresenter extends AbstractCrudPresenter<Employee, EmployeeService, EmployeeAdminView> {

	@Autowired
	public EmployeeAdminPresenter(EmployeeAdminDataProvider employeeAdminDataProvider, NavigationManager navigationManager,
			EmployeeService service, BeanFactory beanFactory) {
		super(navigationManager, service, Employee.class, employeeAdminDataProvider, beanFactory);
	}
}
