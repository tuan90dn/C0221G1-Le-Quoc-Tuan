import {Component, OnInit} from '@angular/core';
// import {CustomerService} from '../../service/customer.service';
// import {CustomerTypeService} from '../../service/customer-type.service';
// import {CustomerType} from '../../model/customer/CustomerType';
// import {FormControl, FormGroup} from '@angular/forms';
import {CustomerType} from '../../../model/customer/CustomerType';
import {CustomerService} from '../../../service/customer.service';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer-create',
  templateUrl: 'customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {
  customerTypes: CustomerType[] = [];
  customerForm: FormGroup = new FormGroup({
    customerType: new FormControl(),
    name: new FormControl(),
    birthday: new FormControl(),
    idCard: new FormControl(),
    phone: new FormControl(),
    email: new FormControl(),
    address: new FormControl()
  });


  constructor(private customerService: CustomerService, private customerTypeService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }
  submit() {
    const customer = this.customerForm.value;
    // customer.customerType = {
    //   id: customer.customerType.id,
    //   name: customer.customerType.name
    // };
    this.customerService.save(customer).subscribe(() => {
      alert('Tạo thành công');
      this.customerForm.reset();
    }, e => console.log(e));
  }
  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }

}
