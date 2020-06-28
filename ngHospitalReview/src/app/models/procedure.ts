import { Post } from './post';

export class Procedure {
  // F I E L D S
  id: number;
  procedureName: string;
  description: string;
  cost: number;
  post: Post;

  // C O N S T R U C T O R
  constructor(id?:number, procedureName?: string, description?: string, cost?: number, post?: Post){
    this.id = id;
    this.procedureName = procedureName;
    this.description = description;
    this.cost = cost;
    this.post = post;
  }

}
