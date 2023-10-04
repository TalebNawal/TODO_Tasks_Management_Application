import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { NgChartsConfiguration, NgChartsModule } from 'ng2-charts';
import { ListComponent } from './task/list/list.component';
import { MaterialModule } from '../material/material.module';
import { NavigationComponent } from '../navigation/navigation.component';
import { AppRoutingModule } from '../app-routing.module';
import { AddComponent } from './task/add/add.component';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { ShowComponent } from './task/show/show.component';
import { FormsModule } from '@angular/forms';

import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { Chart, ChartData } from 'chart.js';
@NgModule({
  declarations: [HomeComponent,ListComponent,NavigationComponent,AddComponent,ShowComponent, LoginComponent, RegisterComponent
  ],
  imports: [
    CommonModule,
    NgChartsModule,
    MaterialModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    MatDialogModule,
    MatIconModule,
    MatButtonModule,
  
    
  
    
  

  ],
  exports:[HomeComponent,NavigationComponent,FormsModule,RegisterComponent,LoginComponent,NgChartsModule,AppRoutingModule,ReactiveFormsModule,MatButtonModule,MatIconModule,ShowComponent,MatDialogModule]
})
export class ComponentModule { }
