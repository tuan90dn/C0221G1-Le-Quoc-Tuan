import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer/CustomerType';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  public apiUrl = 'http://localhost:3000/customer-types';
  constructor(private http: HttpClient) { }
  getAll(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(this.apiUrl);
  }
}
