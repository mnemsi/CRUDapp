package nemsi.Mejddeddine.SpringBootAngularProject.controller;


import nemsi.Mejddeddine.SpringBootAngularProject.exception.RessourceNotFoundException;
import nemsi.Mejddeddine.SpringBootAngularProject.model.Employee;
import nemsi.Mejddeddine.SpringBootAngularProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String homePage(){
        return "welcome";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees/save")
    public void saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @GetMapping( "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  Long id){
        Employee employeeFound = employeeRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("can't find the employee"));
        return ResponseEntity.ok(employeeFound);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("employee with id = " + id+ " not existing"));

        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmailId(employee.getEmailId());

        employeeRepository.save(employeeToUpdate);

        return ResponseEntity.ok(employeeToUpdate);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RessourceNotFoundException("employee not found"));
        employeeRepository.deleteById(id);
        return ResponseEntity.ok(employee);
    }

}
