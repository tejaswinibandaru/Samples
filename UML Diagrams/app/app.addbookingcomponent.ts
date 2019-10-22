import { Component, OnInit} from '@angular/core'
import { BusService } from './_service/app.busservice';
import { Router, ActivatedRoute } from '@angular/router';
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';

@Component({
    selector: 'addbooking',
    templateUrl:'../app/_html/app.addbooking.html'
})
export class AddBookingComponent implements OnInit{
    sources:string[];
    destinations:string[];
    runningBuses:BusTransaction[]=[];
    src:string;
    dest:string;
    journeydate:any;
    loadComponent=false;
    constructor(private busservice:BusService,private router:Router,private bookingService:BookingService,private route:ActivatedRoute){}

    ngOnInit(){
        this.busservice.getSources().subscribe((data:string[])=>this.sources=data);
        this.busservice.getDestinations().subscribe((data:string[])=>this.destinations=data);
    }

    searchRunningBuses(){
        this.loadComponent=true;
        this.busservice.showRunningBuses(this.src,this.dest,this.journeydate).subscribe((data:BusTransaction[])=>this.runningBuses=data);
        console.log(this.runningBuses);
    }

    navigate(){
        this.router.navigate(['/addpassenger']);
    }

}