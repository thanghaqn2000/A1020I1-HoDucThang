export interface Person {
  email: string,
  password: string,
  age: number,
  country: string,
  gender: boolean,
  phone: string
}

export const personDao: Person[] = [
  {
    email: "Toàn",
    password: "123",
    age: 20,
    country: "Việt Nam",
    gender: true,
    phone: "0123456"
  },
  {
    email: "Vi",
    password: "123",
    age: 20,
    country: "Việt Nam",
    gender: false,
    phone: "0123456"
  },
  {
    email: "Thái",
    password: "123",
    age: 20,
    country: "Việt Nam",
    gender: true,
    phone: "0123456"
  },
];


