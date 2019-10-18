import { Component, OnInit,OnChanges,OnDestroy} from '@angular/core'
import { ProductService} from './_service/app.productservice';
import {Product} from './_model/app.product';

@Component({
    selector: 'prod',
    templateUrl: 'app.product.html'
})
export class ProductComponent implements OnInit{
    /*prodId: number;
    prodName: string;
    prodPrice: number;*/
    products: Product[] = [];
    loadComponent = false;
    constructor(private service:ProductService){
        console.log("In constructor....");
    }
    // ngOnChanges(){
    //     console.log("NG On Changes.....");
    // }
    ngOnInit(): void {
        console.log("NG On Init....");
        this.service.getAllData().subscribe((data:Product[]) =>this.products=data);
     }
    //  ngOnDestroy(){
    //      console.log("NG On Destroy....");
         
    //  }
    // addProduct(): any {
    //     this.products.push({ prodId: this.prodId, prodName: this.prodName, prodPrice: this.prodPrice });
    // }

    // updateProduct(index): any {
    //     this.loadComponent=true;
    // }

    // deleteProduct(index): any {
    //     this.products.splice(index, 1);
    // }
}