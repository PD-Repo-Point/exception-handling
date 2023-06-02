package pd.workshop.service;

import org.springframework.stereotype.Service;
import pd.workshop.exception.EmployeeAlreadyExistsException;
import pd.workshop.exception.NoSuchEmployeeExistsException;
import pd.workshop.model.Employee;
import pd.workshop.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl
        implements EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).orElseThrow(
                () -> new NoSuchEmployeeExistsException(
                        "NO SUCH EMPLOYEE EXISTS WITH ID : "+id));
    }

    @Override
    public String addEmployee(Employee employee) {

        Employee existingEmployee  =
                employeeRepo.findById(employee.getId())
                        .orElse(null);

        if(existingEmployee == null){
            employeeRepo.save(employee);
            return "Employee added successfully";
        } else{
            throw new EmployeeAlreadyExistsException(
                    "Employee already exists");
        }
    }

    @Override
    public String updateEmployee(Employee employee) { // new date employee
        Employee existingEmployee  = // old employee
                employeeRepo.findById(employee.getId())
                        .orElse(null);

        if(existingEmployee == null){
            throw new NoSuchEmployeeExistsException(
                    "No Such employee exists exception");
        } else{
            existingEmployee.setName(employee.getName());
            existingEmployee.setAddress(employee.getAddress());

            employeeRepo.save(existingEmployee); // merge - Persistence Context

            return "Employee updated successfully";
        }
    }
}
