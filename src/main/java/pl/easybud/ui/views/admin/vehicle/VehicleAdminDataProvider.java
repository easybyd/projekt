package pl.easybud.ui.views.admin.vehicle;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.spring.annotation.PrototypeScope;
import pl.easybud.backend.data.entity.Vehicle;
import pl.easybud.backend.service.VehicleService;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@PrototypeScope
public class VehicleAdminDataProvider extends FilterablePageableDataProvider<Vehicle, Object> {

  private final VehicleService vehicleService;

  @Autowired
  public VehicleAdminDataProvider(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @Override
  protected Page<Vehicle> fetchFromBackEnd(Query<Vehicle, Object> query, Pageable pageable) {
    return vehicleService.findAnyMatching(getOptionalFilter(), pageable);
  }

  @Override
  protected int sizeInBackEnd(Query<Vehicle, Object> query) {
    return (int) vehicleService.countAnyMatching(getOptionalFilter());
  }

  @Override
  protected List<QuerySortOrder> getDefaultSortOrders() {
    List<QuerySortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
    return sortOrders;
  }

}