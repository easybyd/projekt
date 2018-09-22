package pl.easybud.ui.views.admin;

import com.vaadin.ui.ComboBox;
import pl.easybud.backend.data.JobStatus;

public class JobStatusSelect extends ComboBox<String> {

  public JobStatusSelect() {
    setCaption("Status");
    setEmptySelectionAllowed(false);
    setItems(JobStatus.getAllJobStatus());
    setTextInputAllowed(false);
  }
}
