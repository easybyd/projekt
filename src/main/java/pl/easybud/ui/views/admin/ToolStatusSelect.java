package pl.easybud.ui.views.admin;

import com.vaadin.ui.ComboBox;
import pl.easybud.backend.data.ToolStatus;

public class ToolStatusSelect extends ComboBox<String> {

  public ToolStatusSelect() {
    setCaption("Status");
    setEmptySelectionAllowed(false);
    setItems(ToolStatus.getAllToolStatus());
    setTextInputAllowed(false);
  }
}
