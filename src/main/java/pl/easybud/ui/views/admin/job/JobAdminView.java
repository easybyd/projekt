package pl.easybud.ui.views.admin.job;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Focusable;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Job;
import pl.easybud.ui.views.admin.AbstractCrudView;

import javax.annotation.PostConstruct;

@SpringView
public class JobAdminView extends AbstractCrudView<Job> {

	private final JobAdminPresenter presenter;

	private final JobAdminViewDesign userAdminViewDesign;

	@Autowired
	public JobAdminView(JobAdminPresenter presenter) {
		this.presenter = presenter;
		userAdminViewDesign = new JobAdminViewDesign();
	}

	@PostConstruct
	private void init() {
		presenter.init(this);
		getGrid().setColumns("name", "label", "status", "start", "end");

	}

	@Override
	public void bindFormFields(BeanValidationBinder<Job> binder) {
		binder.bindInstanceFields(getViewComponent());
	}

	@Override
	public JobAdminViewDesign getViewComponent() {
		return userAdminViewDesign;
	}

	@Override
	protected JobAdminPresenter getPresenter() {
		return presenter;
	}

	@Override
	protected Grid<Job> getGrid() {
		return getViewComponent().list;
	}

	@Override
	protected void setGrid(Grid<Job> grid) {
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