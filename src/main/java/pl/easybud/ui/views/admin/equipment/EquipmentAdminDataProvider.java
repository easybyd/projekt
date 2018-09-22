package pl.easybud.ui.views.admin.equipment;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.spring.annotation.PrototypeScope;
import pl.easybud.backend.data.entity.Equipment;
import pl.easybud.backend.service.EquipmentService;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@PrototypeScope
public class EquipmentAdminDataProvider extends FilterablePageableDataProvider<Equipment, Object> {

  private final EquipmentService equipmentService;

  @Autowired
  public EquipmentAdminDataProvider(EquipmentService equipmentService) {
    this.equipmentService = equipmentService;
  }

  @Override
  protected Page<Equipment> fetchFromBackEnd(Query<Equipment, Object> query, Pageable pageable) {
    return equipmentService.findAnyMatching(getOptionalFilter(), pageable);
  }

  @Override
  protected int sizeInBackEnd(Query<Equipment, Object> query) {
    return (int) equipmentService.countAnyMatching(getOptionalFilter());
  }

  @Override
  protected List<QuerySortOrder> getDefaultSortOrders() {
    List<QuerySortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
    return sortOrders;
  }

}