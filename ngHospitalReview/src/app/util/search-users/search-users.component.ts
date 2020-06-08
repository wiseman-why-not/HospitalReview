import { NgForm } from '@angular/forms';
import { Post } from './../../models/post';
import { User } from './../../models/user';
import { UserService } from './../../services/user.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.css']
})
export class SearchUsersComponent implements OnInit {

  users: User[] = [];
  searchedUsers = [];
    // F I E L D S
    // id: number;
    // username: string;
    // password: string;
    // age: number;
    // gender: string;
    // posts: Post[];

  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.reload();
  }

  reload(): void {
    this.getAllUsers();
  }

  onSubmit() {

  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe(
      data => this.users = data,

      err => console.error('Observe got in an error getting all users : ' + err)
    );
  }

  createNewUser(form: NgForm){
    const user: User = form.value;
    console.log(user);
    this.userService.create(user).subscribe(
      good => {
        this.reload();
        form.reset();
      },

      err => console.error('Observer got in an error creating user: ' + err)
    );

  }




}
