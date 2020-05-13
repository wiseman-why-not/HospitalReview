import { Procedure } from './procedure';
import { Hospital } from './hospital';
import { User } from './user';


export class Post {
  // F I E L D S
  id: number;
  review: string;
  createDate: string;
  user: User;
  hospital: Hospital;
  procedure: Procedure;

  // C O N S T R U C T O R
  constructor(id?: number, review?: string, createDate?: string, user?: User, hospital?: Hospital, procedure?: Procedure){
    this.id = id;
    this.review = review;
    this.createDate = createDate;
    this.user = user;
    this.hospital = hospital;
    this.procedure = procedure;
  }
}
