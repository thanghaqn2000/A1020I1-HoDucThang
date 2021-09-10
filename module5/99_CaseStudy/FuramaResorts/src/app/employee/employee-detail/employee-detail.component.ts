import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../services/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Division, EducationDegree, Employee, Position} from "../models/Employee";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  constructor(private _service: EmployeeService, private router: Router,
              private activeRouter: ActivatedRoute) {
  }

  public listPosition!: Position[];
  public listDivision!: Division[];
  public listEducation!: EducationDegree[];
  public employeeFind!:Employee;
  id!: number;
  message!: string;
  updateForm = new FormGroup({
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
    return this.updateForm.get("emp_id");
  }

  get getBirthday() {
    return this.updateForm.get("birthday");
  }

  get getPosition() {
    return this.updateForm.get("position");
  }

  get getDivision() {
    return this.updateForm.get("division");
  }

  get getEducation() {
    return this.updateForm.get("education");
  }

  get getSalary() {
    return this.updateForm.get("salary");
  }

  get getName() {
    return this.updateForm.get("name");
  }

  get getIdCard() {
    return this.updateForm.get("id_card");
  }

  get getPhone() {
    return this.updateForm.get("phone");
  }

  get getEmail() {
    return this.updateForm.get("email");
  }

  get getAddress() {
    return this.updateForm.get("address");
  }

  get getGender() {
    return this.updateForm.get("gender");
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
    this.activeRouter.paramMap.subscribe(param => {
      // @ts-ignore
      this.id = param.get("id");
      console.log(this.id);
      this._service.findById(Number(this.id)).subscribe(data => {
        this.employeeFind=data;
        this.updateForm.patchValue(data);
        // @ts-ignore
        this.updateForm.get('birthday').patchValue(this.formatDate(data.birthday));
      })
    })
  }

  update() {
    this._service.update(this.id, this.updateForm.value).subscribe(data => {
      this.router.navigateByUrl('detailEmp/' + this.id);
      this.message="Update employee successful";
    });
  }

  // @ts-ignore
  formatDate(date) {
    const d = new Date(date);
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate();
    const year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
  }

  // @ts-ignore
  compareWith(val1, val2) {
    return val1.id === val2.id;
  }



}
