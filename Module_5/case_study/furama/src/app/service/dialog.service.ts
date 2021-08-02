import { Injectable } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDeleteComponent} from '../components/customer/customer-delete/customer-delete.component';
// @ts-ignore
// import {CustomerDeleteComponent} from '../customer/customer-delete/customer-delete.component';
// import {MatDialog} from '@angular/material/dialog';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) { }

  openConfirmDialog(msg) {
    return this.dialog.open(CustomerDeleteComponent, {
      width: '390px',
      panelClass: 'confirm-dialog-container',
      disableClose: true,
      position: { top: '10px' },
      data : {
        message : msg
      }
    });
  }
}
