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

  hospitals = [];
  searchedHospitals = [];
  selected = false;
  searchTerm = '';


  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
    this.reload();
  }

  getAllHospitals() {
    this.hospitalService.index().subscribe(
      data => this.hospitals = data,

      err => console.log('Observer got an error: ' + err)
    );
  }

  getSearchedHospitals(keyword) {
    this.searchTerm = keyword;
    this.hospitalService.searchedHospitals(this.searchTerm).subscribe(
      data => this.searchedHospitals = data,

      err => console.log('Observer got an error: ' + err)
    );
  }

  reload() {
    this.getAllHospitals();
  }


  createNewHospital(form: NgForm) {
    const hospital : Hospital = form.value;
    this.hospitalService.create(hospital).subscribe(
      good => {
        this.getAllHospitals();
        this.reload();
        form.reset();
      },
      err => console.error('Observer got an error: ' + err)
    );

  }

  onSubmit(keyword: string){
    console.log(keyword);
    this.getSearchedHospitals(keyword);
    this.selected = true;
  }


  deleteHospital(id: number): void {
    this.hospitalService.destroyHospital(id);
  }

}
