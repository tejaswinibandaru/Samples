import { Component} from '@angular/core'
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';
import { BusService } from './_service/app.busservice';


@Component({
    selector:'searchrunningbuses',
    templateUrl: './_html/app.showrunningbuses.html'
})
export class ShowRunningBusesComponent{
    constructor(private busService:BusService){}
    
}