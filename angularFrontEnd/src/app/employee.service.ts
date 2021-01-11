import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseURLGetAll= "http://localhost:8080/api/v1/employees";
  private baseURLPost= "http://localhost:8080/api/v1/employees/save";
 // private baseURLGetById= "http://localhost:8080/api/v1/employees/{id}";
  

  constructor(private httpClient : HttpClient) { }
  
  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURLGetAll}`);
  }
  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURLPost}`, employee);
  }

  getEmployeeById(id : number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURLGetAll}/${id}`);
  }

  updateEmployee(id :number, employee:Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURLGetAll}/${id}`, employee);
  }

  deleteEmployee(id : number): Observable<Object>{
      return this.httpClient.delete(`${this.baseURLGetAll}/${id}`);
  }
  }

