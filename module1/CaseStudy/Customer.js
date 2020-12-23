class Customer {
    constructor(name, cmnd, dof, email, address, typeCustomer, discount, amount, rentDays, typeService, typeRoom) {
        this.name = name;
        this.cmnd = cmnd;
        this.email=email;
        this.dof=dof;
        this.address = address;
        this.typeCustomer = typeCustomer;
        this.discount = discount;
        this.amount = amount;
        this.rentDays = rentDays;
        this.typeService = typeService;
        this.typeRoom = typeRoom;
    }
    setName(name) {
        this.name = name;
    }

    getName() {
        return this.name;
    }

    setCmnd(cmnd) {
        this.cmnd = cmnd;
    }

    getCmnd() {
        return this.cmnd;
    }
    setEmail(email) {
        this.email = email;
    }

    getEmail() {
        return this.email;
    }
    setDOF(dof) {
        this.dof = dof;
    }

    getDOF() {
        return this.dof;
    }

    setAddress(address) {
        this.address = address;
    }

    getAddress() {
        return this.address;
    }

    setTypeCustomer(typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    getTypeCustomer() {
        return this.typeCustomer;
    }

    setDiscount(discount) {
        this.discount = discount;
    }

    getDiscount() {
        return this.discount;
    }

    setAmount(amount) {
        this.amount = amount;
    }

    getAmount() {
        return this.amount;
    }

    setRentDays(rentDays) {
        this.rentDays = rentDays;
    }

    getRentDays() {
        return this.rentDays;
    }

    setTypeService(typeService) {
        this.typeService = typeService;
    }

    getTypeService() {
        return this.typeService;
    }

    setTypeRoom(typeRoom) {
        this.typeRoom = typeRoom;
    }

    getTypeRoom() {
        return this.typeRoom;
    }
    payTienPhong(){
        if(this.typeService==="Villa"){
            return "Tiền phòng phải trả: "+500*this.rentDays*(1-(this.discount/100));
        }else if(this.typeService==="House "){
            return "Tiền phòng phải trả: "+300*this.rentDays*(1-(this.discount/100));
        }else if(this.typeService==="Room"){
            return "Tiền phòng phải trả: "+100*this.rentDays*(1-(this.discount/100));
        }else{
            return "Không có loại dịch vụ này! "+this.typeService;
        }
    }

}