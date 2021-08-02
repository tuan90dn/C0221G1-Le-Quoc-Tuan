import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public apiUrl = 'http://localhost:3000/customers';
  constructor(private http: HttpClient) { }
  getAll(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  save(customer): Observable<any> {
    return this.http.post<any>(this.apiUrl, customer);
  }
  findById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
  update(id: number, customer: Customer): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, customer);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
  search(textSearch: string): Observable<any> {
    return this.http.get(this.apiUrl + '?name_like=' + textSearch);
  }
  searchDate(dateOne: any, dateTwo: any): Observable<any> {
    return this.http.get(`${this.apiUrl}/?birthday_gte=${dateOne}&birthday_lte=${dateTwo}`);
  }
}
