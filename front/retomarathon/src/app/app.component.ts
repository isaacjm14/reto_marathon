import { Component } from '@angular/core';
import { ServiceService } from './Service/service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'retomarathon';
  tipo:string ='2';
  ruc:string = '';


  constructor(private service:ServiceService){}

  Register() {
    this.service.register(this.tipo,this.ruc).subscribe( data =>{
      console.log(data);
    }
    );
  }

}
