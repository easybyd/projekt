package pl.easybud.ui.views.admin.employee;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Focusable;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.ui.views.admin.AbstractCrudView;

import javax.annotation.PostConstruct;

@SpringView
public class EmployeeAdminView extends AbstractCrudView<Employee> {

	private final EmployeeAdminPresenter presenter;

	private final EmployeeAdminViewDesign userAdminViewDesign;

	@Autowired
	public EmployeeAdminView(EmployeeAdminPresenter presenter) {
		this.presenter = presenter;
//		this.priceToStringConverter = priceToStringConverter;
		userAdminViewDesign = new EmployeeAdminViewDesign();
	}

	@PostConstruct
	private void init() {
		presenter.init(this);
		// Show three columns: "name", "label" and "status".
		getGrid().setColumns("name", "label", "status");

	}

	@Override
	public void bindFormFields(BeanValidationBinder<Employee> binder) {
		binder.bindInstanceFields(getViewComponent());
	}

	@Override
	public EmployeeAdminViewDesign getViewComponent() {
		return userAdminViewDesign;
	}

	@Override
	protected EmployeeAdminPresenter getPresenter() {
		return presenter;
	}

	@Override
	protected Grid<Employee> getGrid() {
		return getViewComponent().list;
	}

	@Override
	protected void setGrid(Grid<Employee> grid) {
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