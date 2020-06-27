import { MedicalProcedureService } from './../services/medical-procedure.service';
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
  selectedHospital = null;
  selectedHospitalPost : Post[] = [];
  listOfMedicalProcedures: String[] = [];


  constructor(
    private hospitalService: HospitalService,
    private procedureService: MedicalProcedureService
    ) { }

  ngOnInit(): void {
    this.reload();
  }

  getAllHospitals() {
    this.hospitalService.index().subscribe(
      data => this.hospitals = data,

      err => console.log('Observer got an error getting all hospitals: ' + err)
    );
  }

  getSearchedHospitals(keyword) {
    this.searchTerm = keyword;
    this.hospitalService.searchedHospitals(this.searchTerm).subscribe(
      data => this.searchedHospitals = data,

      err => console.log('Observer got an error searching: ' + err)
    );
  }

  reload() {
    this.getAllHospitals();
    this.getProceduresNames();
  }

  createNewHospital(form: NgForm) {
    const hospital : Hospital = form.value;
    this.hospitalService.create(hospital).subscribe(
      good => {
        this.reload();
        form.reset();
      },
      err => console.error('Observer got an error creating: ' + err)
    );

  }

  updateHospitalById(form: NgForm) {
    const hospital : Hospital = form.value;
    this.hospitalService.updateById(hospital.id, hospital).subscribe(
      good => {
        this.reload();
        this.goBack();
      },
      err => console.error('Observer got an error updating: ' + err)
    );
  }

  onSubmit(keyword: string){
    console.log(keyword);
    this.getSearchedHospitals(keyword);
    this.selected = true;
  }


  deleteHospital(id: number): void {
    this.hospitalService.destroyHospital(id).subscribe(
      good => {
        this.reload();
        this.goBack();
      },
      err => console.error('Observer got an error deleting: ' + err)
    );
  }

  getSelectedHospital(chosenHospital: Hospital){
    this.selectedHospital = chosenHospital;
    this.selectedHospitalPost = chosenHospital.posts;
  }

  goBack() {
    this.selectedHospital = null;
  }

  getProceduresNames() {
    this.procedureService.procedureNames().subscribe(
      data => this.listOfMedicalProcedures = data,

      err => console.error('Observer got an error getting procedure names' + err)
    );
  }


    // this update does not work
  // updateHospital(form: NgForm) {
  //   const hospital : Hospital = form.value;
  //   console.log("this is coming for search page component: ");
  //   console.log(form.value);
  //   this.hospitalService.update(hospital).subscribe(
  //     good => {

  //       this.reload();
  //       this.goBack();
  //     },
  //     err => console.error('Observer got an error updating: ' + err)
  //   );
  // }


}
