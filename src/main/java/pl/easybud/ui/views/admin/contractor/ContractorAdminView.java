package pl.easybud.ui.views.admin.contractor;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Focusable;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Contractor;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.ui.views.admin.AbstractCrudView;

import javax.annotation.PostConstruct;

@SpringView
public class ContractorAdminView extends AbstractCrudView<Contractor> {

	private final ContractorAdminPresenter presenter;

	private final ContractorAdminViewDesign contractorAdminViewDesign;

	@Autowired
	public ContractorAdminView(ContractorAdminPresenter presenter) {
		this.presenter = presenter;
		contractorAdminViewDesign = new ContractorAdminViewDesign();
	}

	@PostConstruct
	private void init() {
		presenter.init(this);
		getGrid().setColumns("name", "label", "nip", "regon");

	}

	@Override
	public void bindFormFields(BeanValidationBinder<Contractor> binder) {
		binder.bindInstanceFields(getViewComponent());
	}

	@Override
	public ContractorAdminViewDesign getViewComponent() {
		return contractorAdminViewDesign;
	}

	@Override
	protected ContractorAdminPresenter getPresenter() {
		return presenter;
	}

	@Override
	protected Grid<Contractor> getGrid() {
		return getViewComponent().list;
	}

	@Override
	protected void setGrid(Grid<Contractor> grid) {
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