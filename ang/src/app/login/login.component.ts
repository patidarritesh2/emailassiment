import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  login: any = ''
  message: any = ''
  list: any = []

  constructor(private httpService: HttpServiceService) {

  }

  sendMail() {
    var self = this;
    this.httpService.get('http://localhost:2000/User/fp/' + this.login, function (res: any) {
      self.message = res.result.message;
    })
  }

  readMail() {
    var self = this;
    this.httpService.get('http://localhost:2000/User/readMail/'+ this.login , function (res: any) {
      self.list = res.result.email;
    })
  }


}
