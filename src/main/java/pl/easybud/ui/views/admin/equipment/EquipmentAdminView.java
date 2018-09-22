package pl.easybud.ui.views.admin.equipment;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Focusable;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Equipment;
import pl.easybud.ui.views.admin.AbstractCrudView;

import javax.annotation.PostConstruct;

@SpringView
public class EquipmentAdminView extends AbstractCrudView<Equipment> {

  private final EquipmentAdminPresenter presenter;

  private final EquipmentAdminViewDesign userAdminViewDesign;

  @Autowired
  public EquipmentAdminView(EquipmentAdminPresenter presenter) {
    this.presenter = presenter;
    userAdminViewDesign = new EquipmentAdminViewDesign();
  }

  @PostConstruct
  private void init() {
    presenter.init(this);
    getGrid().setColumns("name", "label", "status", "quarantee");
  }

  @Override
  public void bindFormFields(BeanValidationBinder<Equipment> binder) {
    binder.bindInstanceFields(getViewComponent());
  }

  @Override
  public EquipmentAdminViewDesign getViewComponent() {
    return userAdminViewDesign;
  }

  @Override
  protected EquipmentAdminPresenter getPresenter() {
    return presenter;
  }

  @Override
  protected Grid<Equipment> getGrid() {
    return getViewComponent().list;
  }

  @Override
  protected void setGrid(Grid<Equipment> grid) {
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