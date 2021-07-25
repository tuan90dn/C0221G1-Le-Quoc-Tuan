import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../model/customer/Customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [
    {
      id: 1,
      idCustomerType: 1,
      name: 'tuấn',
      birthday: '28/11/1990',
      idCard: '123456789',
      phone: '0905060708',
      email: 'tuan@gmail.com',
      address: 'đà nẵng'
    },
    {
      id: 2,
      idCustomerType: 2,
      name: 'toàn',
      birthday: '14/11/2000',
      idCard: '123456789',
      phone: '0905060708',
      email: 'toan@gmail.com',
      address: 'quảng nam'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
