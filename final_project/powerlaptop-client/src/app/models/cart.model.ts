import { ProductOrderModel } from "./product-order.model";

export interface CartModel {
  created: Date;
  price: string;
  entries: ProductOrderModel[]
}
