import { Injectable } from '@angular/core';
import {CustomerDeleteComponent} from '../customer/customer-delete/customer-delete.component';
import {MatDialog} from '@angular/material/dialog';

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
      data :{
        message : msg
      }
    });
  }
}
