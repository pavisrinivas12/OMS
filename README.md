# OMS
Order Management System

Tools used:

Use any IDE to develop the project. 
It may be Eclipse /Myeclipse / Netbeans etc. I Have developed it using Netbeans.
MySQL for the database.

Front End and Back End
Front End: Java Swing
Back End: MySQL

How to Run the Project:

Import sql files to create tables in mysql.
Import the project on the NetBeans IDE and run it.
If using Eclipse Please install the dependencies, If Netbeans just install MySql dependencies.

OMS:

Users of the System
Supplier[Admin]
Foo's Customers

Functional Requirements

1. Supplier[Admin]
Can add/view/delete Products
Can logout
Can View Customer and his order
Can View Customer Phone Num and Call

2. Foo's Customers
Can View product
Can Order product [Via Viewing Product and ordering it]
Can View Orders
Can Cancel orders
Can logout

Classes Used:

Order Management Main Page.java [Main Page]

If login as Admin:

Admin Login.java [Supplier's Login Page]  
[login details username: admin and password: admin123]
If login successfull goes to Admin menu Page

Admin Sucess.java
	1.addProducts [Addproduct.java]
	2.logout [goes to ordermanagemenetmainpage.java]
	3.View Customer and his order [CustomerOrderDAO.java]
	4.Call [CallCust.java]
	5.Delete Product [DeleteProduct.java]

If Login fails, throw error message

If Customer:
show sigin/signup page [Foocustomerlogin1.java]

If customer signup then Moves to customer signup page [CustSignup.java]
If customer signin then move to customer login in page [FooCustomerlogin.java]
[[login details username[id]: CUST1 and password: pavi123] refer customer table for other logins

If Login fails, throw error message
if login success move to CustSucess.java
1.View Product [ viewproduct.java]
2.view order [vieworder.java]
3.cancel order [OrderDao.java]
4.logout  [goes to ordermanagemenetmainpage.java]


MySql 
Schema: Created schema oms
created tables Customer, ordertab, product

Customer has id,password,name,address,phonenum,emailid
He logins using his username[id] and his password
Admin logins using username: admin and password: admin123

Product Table has prod id, name,description, price,quantity

Ordertab has order id,prodid,custid,orderdate,orderstatus
