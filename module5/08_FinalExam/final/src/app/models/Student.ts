export interface Student {
  id: number,
  id_Student: number,
  name: string,
  teachers: Teacher,
  birthday: string,
  gender: string,
  address: string,
}

export interface Teacher {
  id: number,
  name: string
}
export interface KhachHang {
  id:number,
  ten:string
}
export interface SoTietKiem {
  id:number,
  khachHang:KhachHang,
  ngayMo:string,
  thoiGianGui:string,
  kiHan:string,
  soTienGui:number,
  laiSuat:number,
  uuDai:string
}
