import { Component, OnInit } from '@angular/core';
import { Leave } from '../leave';
import { LeaveService } from '../leave.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  requests: Leave[] = [];

  constructor(private _service: LeaveService) { }

  ngOnInit(): void {
    this.getRequests();
  }

  private getRequests(){
    this._service.getRequests().subscribe(data =>{
      this.requests = data;
    })
  }

}
