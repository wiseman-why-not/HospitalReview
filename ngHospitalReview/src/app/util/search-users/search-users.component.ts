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
  foundUsers = false;
  selectedUser = null;
  selectedUserPost : Post[] = [];
  searchTerm = '';
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

  searchUsers(keyword: string) {
    this.searchTerm = keyword;
    console.log(this.searchTerm);
    this.userService.searchUsersByKeyword(this.searchTerm).subscribe(
      good => this.searchedUsers = good,

      err => console.error('Observer got in an error getting users by keyword: ' + err)
    );
    this.foundUsers = true;
  }

  getSelectedUser(chosenUser: User){
    this.selectedUser = chosenUser;
    this.selectedUserPost = chosenUser.posts;
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

  updateUser(form: NgForm) {
    const updatedUser = form.value;
    console.log(updatedUser);
    this.userService.update(updatedUser.id, updatedUser).subscribe(
      good => {
        this.reload();
        this.goBack();
      },
      err => console.error('Observer got in an updating a user: ' + err)
    );
  }



  deleteUser(id: number) : void {
    this.userService.deleteById(id).subscribe(
      good => {
        this.reload();
        this.goBack();
      },

      err => console.error('Observer got in an error deleting user: ' + err)
    );
  }

  goBack(){
    this.selectedUser = null;
  }


}
