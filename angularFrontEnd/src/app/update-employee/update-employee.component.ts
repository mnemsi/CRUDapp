import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id !: number;
  employee : Employee = new Employee()  ;

  constructor(private employeeService : EmployeeService, private activateRoute: ActivatedRoute, private router : Router ) { }

  ngOnInit(): void {
    //to get the id from the URL
    this.id = this.activateRoute.snapshot.params['id'];
    /* this employee that we created in the class will get the data from the next action so we can show it in the form*/
    this.employeeService.getEmployeeById(this.id)
                        .subscribe(data => {this.employee = data;}, error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    this.employeeService.updateEmployee(this.id, this.employee).subscribe( data =>{
      this.goToEmployeeList();
      
    }
    , error => console.log(error));
  }

}
