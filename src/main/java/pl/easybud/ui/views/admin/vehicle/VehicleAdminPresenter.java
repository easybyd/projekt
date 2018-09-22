package pl.easybud.ui.views.admin.vehicle;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.backend.data.entity.Vehicle;
import pl.easybud.backend.service.EmployeeService;
import pl.easybud.backend.service.VehicleService;
import pl.easybud.ui.navigation.NavigationManager;
import pl.easybud.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class VehicleAdminPresenter extends AbstractCrudPresenter<Vehicle, VehicleService, VehicleAdminView> {

	@Autowired
	public VehicleAdminPresenter(VehicleAdminDataProvider vehicleAdminDataProvider, NavigationManager navigationManager,
			VehicleService service, BeanFactory beanFactory) {
		super(navigationManager, service, Vehicle.class, vehicleAdminDataProvider, beanFactory);
	}
}
