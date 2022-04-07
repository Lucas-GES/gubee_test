import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, EMPTY, Observable } from 'rxjs';
import { Product } from '../product';
import { Products2Service } from '../products2.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$! : Observable<Product[]>;

  constructor(
    private service: Products2Service,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.onRefresh();
  }

  onRefresh(){
    this.products$ = this.service.listAllProducts()
      .pipe(
        catchError(error => {
          console.log(error);
          this.handleError();
          return EMPTY;
        })
      )
  }

  handleError(){
    alert("Error 404");
  }

}
