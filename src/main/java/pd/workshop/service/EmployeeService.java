package pd.workshop.service;

import pd.workshop.model.Employee;

public interface EmployeeService {
    Employee getEmployee(Long id);
    String addEmployee(Employee employee);
    String updateEmployee(Employee employee);
}
