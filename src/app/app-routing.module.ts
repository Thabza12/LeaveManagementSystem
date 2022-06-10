import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LeaveFormComponent } from './leave-form/leave-form.component';
import { RequestsComponent } from './requests/requests.component';

const routes: Routes = [
  {path: '', component: LeaveFormComponent},
  {path: 'requests', component: RequestsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
