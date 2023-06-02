package pd.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pd.workshop.model.Employee;

public interface EmployeeRepo
        extends JpaRepository<Employee, Long> {
}
