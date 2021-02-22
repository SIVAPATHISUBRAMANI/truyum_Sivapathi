create database truYumsqlmodel;
use truYumsqlmodel;

/*View Menu Item List Admin (TYUC001)*/
create table menu_item(id int primary key,Name varchar(30),Price int,Active varchar(10),Date_of_Launch date,Category varchar(30),Free_Delivery varchar(10));
insert into menu_item(id,Name,Price,Active,Date_of_Launch,Category,Free_Delivery)
values(1,"Sandwich",99,"Yes","2017-03-15","Main Course","Yes"),
(2,"Burger",129,"Yes","2017-12-23","Main Course","No"),
(3,"Pizza",149,"Yes","2017-08-21","Main Course","No"),
(4,"French Fries",57,"No","2017-07-02","Starters","Yes"),
(5,"Chocolate Brownie",32,"Yes","2022-11-02","Dessert","Yes");
select * from menu_item;


/*View Menu Item List Customer (TYUC002)*/
select * from menu_item
where  Active="Yes" && year(Date_of_Launch)>2021 ;
/*Edit Menu Item (TYUC003)*/
select * from menu_item 
where  id=1 ;

update  menu_item
set Name="ice cream",Price=150,Active="Yes",Date_of_Launch="2017-05-02",Category="Dessert",Free_Delivery="Yes"
where id=1;


/*Add to Cart (TYUC004)*/
create table user(user_id int auto_increment primary key);
insert into user(user_id) values(1),(2);
select * from user;

create table cart(u_id int,
m_id int,
cart_id int primary Key,
Name varchar(30),
Free_delivery varchar(30),
price int,
category varchar(30),
constraint fk1 foreign key(u_id) references user(user_id),
constraint fk2 foreign key(m_id) references  menu_item(id)
);

insert into cart(u_id,m_id,cart_id,Name,Free_delivery,price,category)values(1,1,1,"Sandwich","Yes",99,"Main Course"),
(1,2,2,"Burger","No",129,"Main Course"),
(1,3,3,"pizza","No",149,"Main Course");

/*View Cart (TYUC005)*/
select c.cart_id,c.Name,c.Free_delivery,c.price,c.category from menu_item m join cart c on m.id=c.m_id
where c.u_id=1;


select sum(c.price) from user u 
join cart c on u.user_id=c.u_id
where u.user_id=1;

/*Remove Item from Cart (TYUC006)*/
delete from cart
where u_id=1 and m_id=1;
select * from cart;