package pl.easybud.ui.views.admin.employee;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.spring.annotation.PrototypeScope;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.backend.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@PrototypeScope
public class EmployeeAdminDataProvider extends FilterablePageableDataProvider<Employee, Object> {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeAdminDataProvider(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	protected Page<Employee> fetchFromBackEnd(Query<Employee, Object> query, Pageable pageable) {
		return employeeService.findAnyMatching(getOptionalFilter(), pageable);
	}

	@Override
	protected int sizeInBackEnd(Query<Employee, Object> query) {
		return (int) employeeService.countAnyMatching(getOptionalFilter());
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		List<QuerySortOrder> sortOrders = new ArrayList<>();
		sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
		return sortOrders;
	}

}