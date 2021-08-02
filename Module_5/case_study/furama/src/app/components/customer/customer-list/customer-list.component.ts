import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../model/customer/Customer';
import {CustomerService} from '../../../service/customer.service';
import {DialogService} from '../../../service/dialog.service';
// // @ts-ignore
// import {Customer} from '../../model/customer/Customer';
// // @ts-ignore
// import {CustomerService} from '../../service/customer.service';
//
// // @ts-ignore
// import {DialogService} from '../../service/dialog.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  constructor(private customerService: CustomerService,
              private dialogService: DialogService) { }
  customers: Customer[] = [];
  key = 'id';
  textSearch = '';
  reverse = false;
  p = 1;
  firstDate = '';
  secondDate = '';

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
        this.customerService.delete(id).subscribe(() => {
          this.ngOnInit();
        });
      }
    });
  }
  search() {
    this.customerService.search(this.textSearch).subscribe(customers => {
      this.customers = customers;
    });
  }
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  searchByDate() {
    this.customerService.searchDate(this.firstDate, this.secondDate).subscribe(customers => {
      this.customers = customers;
    });
  }
}
