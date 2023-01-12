import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentsListComponent} from "./students-list/cours-model-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'students', pathMatch: 'full' },
  { path: 'students', component: StudentsListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
