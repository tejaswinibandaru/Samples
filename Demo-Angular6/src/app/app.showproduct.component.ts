import { Component} from '@angular/core'

@Component({
    selector: 'show',
    template: `<h1>Show Products</h1><br>
    <table border='1'>
    <tr>
    <td>Product Id</td>
    <td>Product Name</td>
    <td>Product Type</td>
    </tr>
    </table>`
})
export class ShowProduct{
}
