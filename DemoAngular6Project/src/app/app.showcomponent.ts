import { Component,OnInit} from '@angular/core';
import { ProductService} from './_service/app.productservice';
import {Product} from './_model/app.product';

@Component({
    selector:'show',
    templateUrl:'app.showproduct.html'
})
export class ShowComponent implements OnInit{
    products: Product[] = [];
    constructor(private service:ProductService){
        console.log("In constructor....");
    }
    ngOnInit(): void {
        console.log("NG On Init....");
        this.service.getAllData().subscribe((data:Product[]) =>this.products=data);
     }

}