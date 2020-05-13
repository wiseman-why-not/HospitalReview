import { User } from './../models/user';
import { Procedure } from './../models/procedure';
import { Component, OnInit } from '@angular/core';
import { Hospital } from '../models/hospital';
import { Post } from '../models/post';

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
  // hard coded hospitals
  hospitals = [
    {
      id: 1,
      name: "saint jude",
      street: "123 street",
      city: "denver",
      state: "CO",
      zipCode: 80218
    },
    {
      id: 2,
      name: "childres",
      street: "213 street",
      city: "Auroroa",
      state: "CO",
      zipCode: 80218
    },
    {
      id: 3,
      name: "mercy",
      street: "321 street",
      city: "Golden",
      state: "CO",
      zipCode: 80218
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
