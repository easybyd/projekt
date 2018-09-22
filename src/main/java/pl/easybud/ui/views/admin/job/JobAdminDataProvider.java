package pl.easybud.ui.views.admin.job;

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
import pl.easybud.backend.data.entity.Job;
import pl.easybud.backend.service.EmployeeService;
import pl.easybud.backend.service.JobService;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@PrototypeScope
public class JobAdminDataProvider extends FilterablePageableDataProvider<Job, Object> {

	private final JobService jobService;

	@Autowired
	public JobAdminDataProvider(JobService jobService) {
		this.jobService = jobService;
	}

	@Override
	protected Page<Job> fetchFromBackEnd(Query<Job, Object> query, Pageable pageable) {
		return jobService.findAnyMatching(getOptionalFilter(), pageable);
	}

	@Override
	protected int sizeInBackEnd(Query<Job, Object> query) {
		return (int) jobService.countAnyMatching(getOptionalFilter());
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		List<QuerySortOrder> sortOrders = new ArrayList<>();
		sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
		return sortOrders;
	}

}