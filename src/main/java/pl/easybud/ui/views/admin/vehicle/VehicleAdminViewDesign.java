package pl.easybud.ui.views.admin.vehicle;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import pl.easybud.backend.data.entity.Vehicle;
import pl.easybud.ui.views.admin.ToolStatusSelect;

@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class VehicleAdminViewDesign extends VerticalLayout {
  protected TextField search;
  protected Button add;
  protected CssLayout listParent;
  protected Grid<Vehicle> list;
  protected VerticalLayout form;
  protected TextField name;
  protected TextField label;
  protected ToolStatusSelect status;
  protected DateField purchase;
  protected TextField regNumber;
  protected DateField insurance;
  protected DateField inspection;
  protected TextField seats;
  protected TextArea description;
  protected Button update;
  protected Button cancel;
  protected Button delete;

  public VehicleAdminViewDesign() {
    Design.read(this);
  }
}
