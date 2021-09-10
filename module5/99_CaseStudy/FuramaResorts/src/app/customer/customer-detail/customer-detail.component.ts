import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ICustomer} from "../model/customer";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ICustomerType} from "../model/typeCustomer";
import {TypeCustomerService} from "../services/type-customer.service";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  customer!: ICustomer;
  customerTypes!: ICustomerType[];
  id!: string;
  message!:string;
  constructor(private _service: CustomerService, private activeRouter: ActivatedRoute, private _serviceTypeCus: TypeCustomerService,
              private router: Router) {
  }

  updateForm = new FormGroup({
      id: new FormControl(''),
      cus_id: new FormControl('', [Validators.required, Validators.pattern("^KH-[\\d]{4}$")]),
      cus_type: new FormControl('',[Validators.required]),
      name: new FormControl('',[Validators.required]),
      birthday: new FormControl('',[Validators.required]),
      gender: new FormControl('',[Validators.required]),
      id_card: new FormControl('',[Validators.required,Validators.pattern("^(\\d{9}$)")]),
      phone: new FormControl('',[Validators.required,Validators.pattern("0?(\\d{10}$)")]),
      email: new FormControl('',[Validators.required,Validators.pattern("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")]),
      address: new FormControl('',[Validators.required])
    }
  );

  get getCusId() {
    return this.updateForm.get("cus_id");
  }
  get getBirthday() {
    return this.updateForm.get("birthday");
  }
  get getType() {
    return this.updateForm.get("cus_type");
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
    this._serviceTypeCus.getAllType().subscribe(data => {
      // @ts-ignore
      this.customerTypes = data;
    });
    this.activeRouter.paramMap.subscribe((param) => {
      // @ts-ignore
      this.id = param.get("id");

      // @ts-ignore
      this._service.findById(Number(this.id)).subscribe((data: ICustomer) => {
          this.updateForm.patchValue(data);
          // @ts-ignore
          this.updateForm.get('birthday').patchValue(this.formatDate(data.birthday));
        }
      );
    })
  }

  updateCus() {
    console.log(this.updateForm.get("name"));
    this._service.update(this.id, this.updateForm.value).subscribe(data => {
      this.router.navigateByUrl('detailCus/' + this.id);
      this.message="Update customer successful";
    })
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
