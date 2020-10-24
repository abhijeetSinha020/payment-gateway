import { Component, OnInit } from '@angular/core';
import { Order } from './models/order';
import { PaymentService } from './payment.service'
import { Item } from './models/item'
import { WindowRefService } from './window-ref.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  options = {
    "key": "", // Enter the Key ID generated from the Dashboard
    "amount": "", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "",
    "name": "",
    "description": "",
    "image": "",
    "order_id": "", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "handler": function (response) {
      alert(response.razorpay_payment_id);
      alert(response.razorpay_order_id);
      alert(response.razorpay_signature)
    },
    "prefill": {
      "name": "",
      "email": "",
      "contact": ""
    },
    "notes": {
      "address": "buzzingatech.com"
    },
    "theme": {
      "color": "#F37254"
    }
  }
  constructor(private paymentS: PaymentService,private winRef: WindowRefService) { }

  ngOnInit() {
    this.getOrders();
  }
  orders: Order[] = [];


  getOrders() {
    this.paymentS.getOrderList().subscribe(data => {
      console.log("data", data)
      this.orders = data
    })
  }
  generateOrderInfo(item: Item) {
    console.log("ITEM", item)
    this.paymentS.createOrder(item).subscribe(data => {
      console.log("0rder", data)
      this.setRazorPayOptions(data);
      const rzp = new this.winRef.nativeWindow.Razorpay(this.options);
      rzp.open();
    })
  }

  setRazorPayOptions(data: any) {
    this.options.key = data.key;
    this.options.amount = data.amount;
    this.options.currency = data.currency;
    this.options.name = data.organizationName;
    this.options.description = data.description;
    this.options.image = "https://via.placeholder.com/150";
    this.options.order_id = data.razorOrderId;
    this.options.prefill.name = data.customerName;
    this.options.prefill.email = data.customerEmail;
    this.options.prefill.contact = data.customerContact;
    console.log("options", this.options);


  }

}
