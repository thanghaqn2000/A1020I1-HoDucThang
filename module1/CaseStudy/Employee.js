class Employee {
    constructor(nameEmp, DOF, cmnd, sdt, email, level, position) {
        this.nameEmp = nameEmp;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.email = email;
        this.level = level;
        this.position = position;
        this.salary = 0;
    }
    setNameEmp(nameEmp) {
        this.nameEmp = nameEmp;
    }

    getNameEmp() {
        return this.nameEmp;
    }

    setCmndEmp(cmnd) {
        this.cmnd = cmnd;
    }

    getCmndEmp() {
        return this.cmnd;
    }

    setSdtEmp(sdt) {
        this.sdt = sdt;
    }

    getSdtEmp() {
        return this.sdt;
    }

    setEmailEmp(email) {
        this.email = email;
    }

    getEmailEmp() {
        return this.email;
    }

    setLevelEmp(level) {
        this.level = level;
    }

    getLevelEmp() {
        return this.level;
    }

    setPositionEmp(position) {
        this.position = position;
    }

    getPositionEmp() {
        return this.position;
    }

    setSalaryEmp(salary) {
        this.salary = salary;
    }

    getSalaryEmp() {
        return this.salary;
    }

    workingPartsEmp() {
        if (this.position.toLowerCase() === 'manager') {
            return 'Nhân viên này thuộc bộ phận quản lí';
        } else if (this.position.toLowerCase() === 'sale' || this.position.toLowerCase() === 'marketing') {
            return 'Nhân viên này thuộc bộ phận Sale-Marketing';
        }
    }

    salaryOfEmp() {
        if (this.position.toLowerCase() === 'manager') {
            return this.salary = 500;
        } else if (this.position.toLowerCase() === 'sale') {
            return this.salary = 300;
        } else if (this.position.toLowerCase() === 'marketing') {
            return this.salary = 200;
        } else {
            return "Không có vị trí này";
        }
    }
}