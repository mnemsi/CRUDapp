package nemsi.Mejddeddine.SpringBootAngularProject.repository;

import nemsi.Mejddeddine.SpringBootAngularProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
