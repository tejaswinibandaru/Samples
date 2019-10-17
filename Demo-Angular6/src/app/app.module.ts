import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { AppProductComponent } from './app.product.component';
import { ShowProduct} from './app.showproduct.component'
import {FormsModule} from '@angular/forms'

@NgModule({
    imports: [
        BrowserModule,
        FormsModule
        
    ],
    declarations: [
        AppComponent,AppProductComponent,ShowProduct
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }