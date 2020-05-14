import { HospitalService } from './../services/hospital.service';
import { User } from './../models/user';
import { Procedure } from './../models/procedure';
import { Component, OnInit } from '@angular/core';
import { Hospital } from '../models/hospital';
import { Post } from '../models/post';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {
  hospital = new Hospital;
  user = new User;
  post = new Post;
  procedure = new Procedure;
  hospitals = [];
  // hard coded hospitals
  // hospitals = [
  //   {
  //     id: 1,
  //     name: "saint jude",
  //     street: "123 street",
  //     city: "denver",
  //     state: "CO",
  //     zipCode: 80218
  //   },
  //   {
  //     id: 2,
  //     name: "childres",
  //     street: "213 street",
  //     city: "Auroroa",
  //     state: "CO",
  //     zipCode: 80218
  //   },
  //   {
  //     id: 3,
  //     name: "mercy",
  //     street: "321 street",
  //     city: "Golden",
  //     state: "CO",
  //     zipCode: 80218
  //   }
  // ]
  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
    this.getAllHospitals();
  }

  getAllHospitals() {
    this.hospitalService.index().subscribe(
      data => this.hospitals = data,

      err => console.log('Observer got an error: ' + err)
    );
  }

  createNewHospital(data) {
    this.hospitalService.create(data).subscribe(
      data => {
        this.getAllHospitals();
      },
      err => console.error('Observer got an error: ' + err)
    );
  }

  onSubmit(form: NgForm){
    console.log(form.value);
    form.reset();
  }

  // addHospital(hospital: Hospital){
  //   this.hospitalService.create(hospital);
  //   this.hospitals = this.hospitalService.index();
  // }

  deleteHospital(id: number): void {
    this.hospitalService.destroyHospital(id);
  }

}
