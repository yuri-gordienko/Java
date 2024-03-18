export interface DataTableModel<T> {
  page: number;
  size: number;
  totalPages: number;
  totalElements: number;
  first: boolean;
  last: boolean;
  next: boolean;
  previous: boolean;
  sort: string;
  order: string;
  items: T[];
}
