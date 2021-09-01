import { Injectable } from '@angular/core';
import {Person, personDao} from "../models/Person";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  public Persons:Person[]=personDao;

  constructor() { }

}
