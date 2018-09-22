package pl.easybud.ui.views.admin.vehicle;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Focusable;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.backend.data.entity.Vehicle;
import pl.easybud.ui.views.admin.AbstractCrudView;

import javax.annotation.PostConstruct;

@SpringView
public class VehicleAdminView extends AbstractCrudView<Vehicle> {

	private final VehicleAdminPresenter presenter;

	private final VehicleAdminViewDesign userAdminViewDesign;

	@Autowired
	public VehicleAdminView(VehicleAdminPresenter presenter) {
		this.presenter = presenter;
		userAdminViewDesign = new VehicleAdminViewDesign();
	}

	@PostConstruct
	private void init() {
		presenter.init(this);
		getGrid().setColumns("name", "label", "status", "purchase", "regNumber", "insurance", "inspection", "seats");
	}

	@Override
	public void bindFormFields(BeanValidationBinder<Vehicle> binder) {
		binder.bindInstanceFields(getViewComponent());
	}

	@Override
	public VehicleAdminViewDesign getViewComponent() {
		return userAdminViewDesign;
	}

	@Override
	protected VehicleAdminPresenter getPresenter() {
		return presenter;
	}

	@Override
	protected Grid<Vehicle> getGrid() {
		return getViewComponent().list;
	}

	@Override
	protected void setGrid(Grid<Vehicle> grid) {
		getViewComponent().list = grid;
	}

	@Override
	protected Component getForm() {
		return getViewComponent().form;
	}

	@Override
	protected Button getAdd() {
		return getViewComponent().add;
	}

	@Override
	protected Button getCancel() {
		return getViewComponent().cancel;
	}

	@Override
	protected Button getDelete() {
		return getViewComponent().delete;
	}

	@Override
	protected Button getUpdate() {
		return getViewComponent().update;
	}

	@Override
	protected TextField getSearch() {
		return getViewComponent().search;
	}

	@Override
	protected Focusable getFirstFormField() {
		return getViewComponent().name;
	}

}