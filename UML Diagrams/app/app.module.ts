import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import { AddBookingComponent } from './app.addbookingcomponent';
import { ViewBookingsComponent } from './app.viewbookingscomponent';
import { CancelBookingComponent } from './app.cancelbookingcomponent';
import { CustomerHomeComponent } from './app.customerhomecomponent';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SimpleModalModule } from 'ngx-simple-modal';
import { ConfirmComponent } from './confirmdialog/app.confirmcomponent';
import { ShowRunningBusesComponent } from './app.showrunningbusescomponent';
import { DatePipe } from '@angular/common'
import { AddPassengerComponent } from './app.addpassengercomponent';



const brsroute: Routes=[
    {path:'addbooking',component: AddBookingComponent},
    {path:'viewbookings',component: ViewBookingsComponent},
    {path:'cancelbooking/:id',component: CancelBookingComponent},
    {path:'customerhome',component: CustomerHomeComponent},
    {path:'searchrunningbuses',component: ShowRunningBusesComponent},
    {path:'addpassenger',component:AddPassengerComponent}

]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(brsroute),NgbModule.forRoot(),
        SimpleModalModule.forRoot({container: "modal-container"})
    ],
    declarations: [
        AppComponent,AddBookingComponent,ViewBookingsComponent,CancelBookingComponent,
        CustomerHomeComponent,ConfirmComponent,ShowRunningBusesComponent,AddPassengerComponent
		],
    providers: [ DatePipe],
    bootstrap: [AppComponent]
})

export class AppModule { }