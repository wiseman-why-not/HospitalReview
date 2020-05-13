import { Post } from './post';

export class Procedure {
  // F I E L D S
  id: number;
  procdureName: string;
  description: string;
  cost: number;
  post: Post;

  // C O N S T R U C T O R
  constructor(id?:number, procdureName?: string, description?: string, cost?: number, post?: Post){
    this.id = id;
    this.procdureName = procdureName;
    this.description = description;
    this.cost = cost;
    this.post = post;
  }

}
