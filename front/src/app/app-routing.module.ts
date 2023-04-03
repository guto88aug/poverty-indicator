import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AboutComponent} from "./about/about.component";
import {FindComponent} from "./find/find.component";

const routes: Routes = [
  { path: '', redirectTo: 'find', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'find', component: FindComponent },
  { path: 'about', component: AboutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
