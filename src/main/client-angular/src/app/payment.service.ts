import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpHeaderResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './models/order';
import { Item } from './models/item';
@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  url="http://localhost:8080/api/";
  headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    options = new HttpHeaderResponse({ headers: this.headers });

    constructor(private http: HttpClient) { }
getOrderList(): Observable<Order[]> {
        return this.http.get<Order[]>(this.url+"items" ,this.options);
    }

    createOrder(item:Item):Observable<any>{
      return this.http.post<any>(this.url+"payment/orders",item,this.options)
    }
}
