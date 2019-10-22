import { Component } from "@angular/core";

@Component({
    selector:'addpassenger',
    templateUrl:'./_html/app.addpassenger.html'
})
export class AddPassengerComponent{
    passengerName:string;
    passengerAge:number;
    passengerGender:any;
}