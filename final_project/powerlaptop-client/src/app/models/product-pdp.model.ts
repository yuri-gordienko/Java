export interface ProductPdpModel { // должны вытянуть в pdp.component.ts
  id: number;
  productBrand: string;
  name: string;
  description: string;
  images: string[];
  price: string;
  osList: string[];
  cpuList: string[];
  ramList: number[];
  ssdList: number[];
  colorList: string[];
  displayResolutionList: string[];
  displayTypeList: string[];
  displaySizeList: string[];
}
