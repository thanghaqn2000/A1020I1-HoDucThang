class Customer{
    constructor(idKh,nameKH,sdtKH,addressKH,emailKH) {
        this.idKh=idKh;
        this.nameKH=nameKH;
        this.sdtKH=sdtKH;
        this.addressKH=addressKH;
        this.emailKH=emailKH;
    }
    setIdKH(idKh){
        this.idKh=idKh;
    }
    setNameKH(nameKH){
        this.nameKH=nameKH;
    }
    setSdtKH(sdtKH){
        this.sdtKH=sdtKH;
    }
    setAddressKH(addressKH){
        this.addressKH=addressKH;
    }
    setEmailKH(emailKH){
        this.emailKH=emailKH;
    }
    getIdKH(){
        return this.idKh;
    }
    getNameKH(){
        return this.nameKH;
    }
    getSdtKH(){
        return this.sdtKH;
    }
    getAddressKH(){
        return this.addressKH;
    }
    getEmailKH(){
        return this.emailKH;
    }
}