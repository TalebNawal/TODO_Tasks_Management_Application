import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentModule } from './components/component.module';
import { NgChartsModule } from 'ng2-charts';
import { HttpClientModule } from '@angular/common/http';
import { ShowComponent } from './components/task/show/show.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
   
    
    
    
  ],
  imports: [
    BrowserModule,
    ComponentModule,
    NgChartsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
