package pl.easybud.ui.views.admin;

import com.vaadin.ui.ComboBox;
import pl.easybud.backend.data.EmployeeStatus;

public class EmployeeStatusSelect extends ComboBox<String> {

  public EmployeeStatusSelect() {
    setCaption("Status");
    setEmptySelectionAllowed(false);
    setItems(EmployeeStatus.getAllEmplStatus());
    setTextInputAllowed(false);
  }
}
