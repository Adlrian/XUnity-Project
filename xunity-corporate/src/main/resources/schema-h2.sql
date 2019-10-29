create table product (
    id identity primary key,
    name varchar(100) not null,
    description varchar(100) not null,
    price numeric not null,
    stock int not null,
    cvPoints int not null,
    status int not null,
    imageUrl varchar(300) not null,
);

create table customer(
    id identity primary key,
    name varchar(100) not null,
    lastName varchar(100) not null,
    username varchar(100) not null,
    password varchar(100) not null,
    phone varchar(30) not null,
    dni varchar(10) not null,
    address varchar(100) not null,
    enrollerId int not null,
    status int not null,
    customerType int not null,
    marketId int not null,
);