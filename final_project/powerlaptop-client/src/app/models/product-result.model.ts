export interface ProductResultModel {
  price?: string;
  os?: string;
  cpu?: string;
  ram?: number;
  ssd?: number;
  color?: string;
  displayResolution?: string;
  displayType?: string;
  displaySize?: string;
}

export const defaultProductResultModel = {
  os: undefined,
  cpu: undefined,
  ram: undefined,
  ssd: undefined,
  color: undefined,
  displayResolution: undefined,
  displayType: undefined,
  displaySize: undefined,
  price: '999999'
};
