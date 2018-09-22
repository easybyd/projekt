package pl.easybud.ui.views.admin.equipment;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.easybud.backend.data.entity.Equipment;
import pl.easybud.backend.service.EquipmentService;
import pl.easybud.ui.navigation.NavigationManager;
import pl.easybud.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class EquipmentAdminPresenter extends AbstractCrudPresenter<Equipment, EquipmentService, EquipmentAdminView> {

  @Autowired
  public EquipmentAdminPresenter(EquipmentAdminDataProvider equipmentAdminDataProvider,
      NavigationManager navigationManager, EquipmentService service, BeanFactory beanFactory) {
    super(navigationManager, service, Equipment.class, equipmentAdminDataProvider, beanFactory);
  }
}
