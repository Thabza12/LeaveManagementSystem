import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Leave } from '../leave';
import { LeaveService } from '../leave.service';

@Component({
  selector: 'app-leave-form',
  templateUrl: './leave-form.component.html',
  styleUrls: ['./leave-form.component.css']
})
export class LeaveFormComponent implements OnInit {

  leave: Leave = new Leave();

  constructor(private _service: LeaveService,
              private _router: Router) { }

  ngOnInit(): void {
  }

  gotToRequests(){
    this._router.navigate(['requests']);
  }

  onSubmit(){
    console.log(this.leave);
    this._service.createRequest(this.leave).subscribe();
    this.gotToRequests();
    
  }

}
