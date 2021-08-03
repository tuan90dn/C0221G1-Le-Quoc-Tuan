import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerType} from '../../model/customer/CustomerType';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Customer} from '../../model/customer/Customer';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  customerForm: FormGroup;
  id: number;
  customerTypes: CustomerType[] = [];

  constructor(private customerService: CustomerService, private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    });
  }

  ngOnInit(): void {
  }
  compareFn(c1: Customer, c2: Customer): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      this.customerForm = new FormGroup({
        customerType: new FormControl(customer.customerType),
        name: new FormControl(customer.name),
        birthday: new FormControl(customer.birthday),
        idCard: new FormControl(customer.idCard),
        phone: new FormControl(customer.phone),
        email: new FormControl(customer.email),
        address: new FormControl(customer.address)
      });
    });
  }
  update(id: number) {
    const customer = this.customerForm.value;
    this.customerService.update(id, customer).subscribe(() => {
      alert('Cập nhật thành công');
    });
  }


}