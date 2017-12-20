create table catalog(

    idcatalog serial,
    name varchar(255) not null

);

create table category(

    idcategory int not null serial,
    name varchar(255) not null,
    description varchar(255) not null,
    active Boolean not null,

    CONSTRAINT pk_category_idcategory PRIMARY KEY (idcategory)
);


insert into category(name, description, active)
values('product 1', 'pakaian', true);
insert into category(name, description, active)
values('product 2', 'celana', true);
insert into category(name, description, active)
values('product 3', 'kemeja', true);
insert into category(name, description, active)
values('product 4', 'topi', true);

create table product(

    idproduct int not null serial,
    name varchar(255) not null,
    quantity int not null,
    price int not null,
    active Boolean not null,
    idcategory int not null,

    CONSTRAINT pk_product_idproduct PRIMARY KEY (idproduct),
    CONSTRAINT fk_product_idcategory FOREIGN KEY (idcategory)
    REFERENCES category(idcategory)
);


create table checkout(

    idcheckout serial,
    checkdate date not null,

    CONSTRAINT pk_checkout_idcheckout PRIMARY KEY (idcheckout)
);


create table checkout_detil(

    idcheckout int not null,
    idproduct int not null,

    PRIMARY KEY (idcheckout, idproduct),
    CONSTRAINT fk_checkout_detil_idcheckout FOREIGN KEY (idcheckout)
    REFERENCES checkout(idcheckout) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_checkout_detil_idproduct FOREIGN KEY (idproduct)
    REFERENCES product (idproduct) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);


insert into checkout(checkdate) values('2018-01-01');
insert into checkout_detil(idcheckout, idproduct)
values(1, 1);

insert into product(name, quantity, price, active, idcategory)
values('baju reglan', 10, 50000, true, 1);
insert into product(name, quantity, price, active, idcategory)
values('kemeja levis', 80, 10000, false, 3);
