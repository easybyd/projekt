package pl.easybud.ui.views.admin.contractor;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.spring.annotation.PrototypeScope;
import pl.easybud.backend.data.entity.Contractor;
import pl.easybud.backend.data.entity.Employee;
import pl.easybud.backend.service.ContractorService;
import pl.easybud.backend.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@PrototypeScope
public class ContractorAdminDataProvider extends FilterablePageableDataProvider<Contractor, Object> {

	private final ContractorService contractorService;

	@Autowired
	public ContractorAdminDataProvider(ContractorService contractorService) {
		this.contractorService = contractorService;
	}

	@Override
	protected Page<Contractor> fetchFromBackEnd(Query<Contractor, Object> query, Pageable pageable) {
		return contractorService.findAnyMatching(getOptionalFilter(), pageable);
	}

	@Override
	protected int sizeInBackEnd(Query<Contractor, Object> query) {
		return (int) contractorService.countAnyMatching(getOptionalFilter());
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		List<QuerySortOrder> sortOrders = new ArrayList<>();
		sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
		return sortOrders;
	}

}