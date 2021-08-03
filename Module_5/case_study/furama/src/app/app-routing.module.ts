import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from './components/customer/customer-list/customer-list.component';
import {CustomerCreateComponent} from './components/customer/customer-create/customer-create.component';
import {CustomerEditComponent} from './components/customer/customer-edit/customer-edit.component';
import {CustomerDeleteComponent} from './components/customer/customer-delete/customer-delete.component';
import {HomeComponent} from './components/home/home.component';


const routes: Routes = [
  {path: '', component: CustomerListComponent},
  {
    path: 'customer/list',
    component: CustomerListComponent
  }, {
    path: 'customer/create',
    component: CustomerCreateComponent
  }, {
    path: 'customer/edit/:id',
    component: CustomerEditComponent
  }, {
    path: 'customer/delete/:id',
    component: CustomerDeleteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
