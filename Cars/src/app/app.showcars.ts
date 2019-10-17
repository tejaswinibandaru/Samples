import {Component} from '@angular/core'

@Component({
    selector: 'showcar',
    templateUrl:'app.showcarscomponent.html'
})
export class ShowCarByImage{
    pic='';

    onSelectImage(event){
        if(event.target.value=="select"){
            this.pic=null;
        }
        if(event.target.value=="bmw"){
            this.pic="../assets/img/bmw.jpg"
        }
        if(event.target.value=="bmw"){
            this.pic="../assets/img/bmw.jpg"
        }
        if(event.target.value=="audi"){
            this.pic="../assets/img/audi.jpg"
        }
        if(event.target.value=="i20"){
            this.pic="../assets/img/i20.jpg"
        }
        if(event.target.value=="alto"){
            this.pic="../assets/img/alto.jpg"
        }
        if(event.target.value=="maruti"){
            this.pic="../assets/img/maruti.jpg"
        }
    }
}