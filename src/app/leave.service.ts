import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Leave } from './leave';

@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  private baseUrl = "http://localhost:8080/api/v1/requests";
  private newRequest = "http://localhost:8080/api/v1/create";

  constructor(private _http: HttpClient) { }

  getRequests(): Observable<Leave[]>{
    return this._http.get<Leave[]>(`${this.baseUrl}`);
  }

  createRequest(leave: Leave): Observable<Object>{
    return this._http.post<Object>(`${this.newRequest}`, leave);
  }

}
