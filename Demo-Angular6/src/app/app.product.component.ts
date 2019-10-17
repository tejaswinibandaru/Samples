import { Component } from '@angular/core'
import { parseHttpResponse } from 'selenium-webdriver/http';

@Component ({
    selector: 'product',
    templateUrl: 'app.product.component.html'
})
export class AppProductComponent {
    prodId:number;
    prodName:string;
    prodOnline:boolean=false;
    prodType:any;
    pic:string="../assets/img/bus3.jpg";
    products:any[]=[
        {
            prodId: 1001,
            prodName:"Mobile Phone"
        },
        {
            prodId: 1002,
            prodName: "Washing Machine"
        },
        {
            prodId: 1003,
            prodName: "Wireless Headphones"
        }
    ];


    getAllData():any{
        alert("Hello!! Add Product button has been clicked...")
        //console.log(this.prodId+" "+this.prodName)
    }

    deleteData(index):any{
        this.products.splice(index,1);
        alert("Hello!!Product with product id has been deleted");
    }
}