
export interface Employee {
  id: number;
  emp_id: string;
  name: string;
  birthday: string;
  gender: string;
  id_card: string;
  phone: string;
  email: string;
  address: string;
  salary: number;
  position: Position;
  education: EducationDegree;
  division: Division;
}

export interface Position {
  id: number,
  name: string
}

export interface EducationDegree {
  id: number,
  name: string
}

export interface Division {
  id: number,
  name: string
}
