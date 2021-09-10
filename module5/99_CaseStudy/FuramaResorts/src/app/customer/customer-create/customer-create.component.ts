import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../services/customer.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {TypeCustomerService} from "../services/type-customer.service";
import {ICustomerType} from "../model/typeCustomer";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  constructor(private _service: CustomerService, private _typeService: TypeCustomerService, private router: Router) {
  }

  listTypeCustomer!: ICustomerType[];

  createForm = new FormGroup({
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
    return this.createForm.get("cus_id");
  }
  get getBirthday() {
    return this.createForm.get("birthday");
  }
  get getType() {
    return this.createForm.get("cus_type");
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



  create() {
    this._service.create(this.createForm.value).subscribe();
    // console.log(this.createForm.value);
    this.router.navigateByUrl('listCus');
  }

  ngOnInit(): void {
    this._typeService.getAllType().subscribe(data => {
      // @ts-ignore
      this.listTypeCustomer = data;
    })
  }


}
