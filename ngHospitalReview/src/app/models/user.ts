import { Post } from './post';

export class User {
  // F I E L D S
  id: number;
  username: string;
  password: string;
  age: number;
  gender: string;
  posts: Post[];


  // C O N S T R U C T O R
  constructor(id: number, username: string, password: string, age: number, gender: string, posts: Post[]){
    this.id = id;
    this.username = username;
    this.password = password;
    this.age = age;
    this.gender = gender;
    this.posts = posts;
  }
}
