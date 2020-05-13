import { Post } from './post';

export class Hospital {
  // F I E L D S
  id: number;
  name: string;
  street: string;
  city: string;
  state: string;
  zipCode: number;
  posts: Post[];

  // C O N S T R U C T O R S
  constructor(id: number, name: string, street: string, city: string, state: string, zipCode: number, posts: Post[]){
    this.id = id;
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.posts = posts;
  }

}
