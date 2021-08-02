import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer/Customer';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {CustomerType} from '../../model/customer/CustomerType';
import {DialogService} from '../../service/dialog.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  constructor(private customerService: CustomerService,
              private dialogService: DialogService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
  }
  onDelete(id) {
    this.dialogService.openConfirmDialog('Are you sure to delete this record ?')
      .afterClosed().subscribe(res => {
      if (res) {
        this.customerService.delete(id);
        // this.notificationService.warn('! Deleted successfully');
      }
    });
  }
  // getAllCustomerType() {
  //   this.customerTypeService.getAll().subscribe(customerTypes => {
  //     this.customerTypes = customerTypes;
  //   });
  // }

}
