import { HttpClient } from "@angular/common/http";

export class GetService<T> {
    
    constructor(protected http: HttpClient, private API_URL: any){}

    listAllProducts(){
        return this.http.get<T[]>(this.API_URL)
    }
}