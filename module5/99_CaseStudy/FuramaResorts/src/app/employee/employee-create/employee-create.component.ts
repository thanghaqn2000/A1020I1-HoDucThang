import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../services/employee.service";
import {Router} from "@angular/router";
import {Division, EducationDegree, Position} from "../models/Employee";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  constructor(private _service: EmployeeService, private router: Router) {
  }

  public listPosition!: Position[];
  public listDivision!: Division[];
  public listEducation!: EducationDegree[];

  createForm = new FormGroup({
      id: new FormControl(''),
      emp_id: new FormControl('', [Validators.required, Validators.pattern("^NV-[\\d]{4}$")]),
      position: new FormControl('', [Validators.required]),
      education: new FormControl('', [Validators.required]),
      division: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      id_card: new FormControl('', [Validators.required, Validators.pattern("^(\\d{9}$)")]),
      phone: new FormControl('', [Validators.required, Validators.pattern("0?(\\d{10}$)")]),
      email: new FormControl('', [Validators.required, Validators.pattern("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")]),
      address: new FormControl('', [Validators.required]),
      salary: new FormControl('', [Validators.required, Validators.min(20)]),
    }
  );

  get getEmpId() {
    return this.createForm.get("emp_id");
  }

  get getBirthday() {
    return this.createForm.get("birthday");
  }

  get getPosition() {
    return this.createForm.get("position");
  }
  get getDivision() {
    return this.createForm.get("division");
  }
  get getEducation() {
    return this.createForm.get("education");
  }

  get getSalary() {
    return this.createForm.get("salary");
  }

  get getName() {
    return this.createForm.get("name");
  }

  get getIdCard() {
    return this.createForm.get("id_card");
  }

  get getPhone() {
    return this.createForm.get("phone");
  }

  get getEmail() {
    return this.createForm.get("email");
  }

  get getAddress() {
    return this.createForm.get("address");
  }

  get getGender() {
    return this.createForm.get("gender");
  }

  create(){
    this._service.create(this.createForm.value).subscribe( );
    this.router.navigateByUrl('listEmp');
  }
  ngOnInit(): void {
    this._service.getAllPosition().subscribe(data => {
      this.listPosition = data;
    });
    this._service.getAllDivision().subscribe(data => {
      this.listDivision = data;
    });
    this._service.getAllEducation().subscribe(data => {
      this.listEducation = data;
    });
  }

}
