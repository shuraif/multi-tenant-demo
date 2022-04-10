# multi-tenant-demo
Springboot multi tenant application demo.

![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) ![](https://img.shields.io/github/release/pandao/editor.md.svg) ![](https://img.shields.io/bower/v/editor.md.svg)

**What is Multi-tenancy?**

Multi-tenancy is an architecture where one software application works for multiple customers. Each customer is called a tenant. This can be achieved in 3 different methods.

   - **Database per Tenant**, Each Tenant has its own database and is isolated from other tenants.
   - **Shared Database**, Shared Schema: All Tenants share same database and tables. Every table has a Column for identify Tenant.
   - **Shared Database**, Separate Schema: All Tenants share a database, but have their own database schemas and tables.
  

This sample application demonstrate the first aproach, **Database per Tenant**. In this sample we are going to use 2 databases.
 - Default
 - Tenant-1


**Usage**

-  clone the code.
-  create schema and table with same name in multiple databases.
        CREATE TABLE public.userdetails (phonehash text NOT NULL,passwordhash text NOT NULL,lastlogin timestamp NOT NULL,createdon timestamp NOT NULL,CONSTRAINT userdetails_pkey PRIMARY KEY (phonehash));
-  Configure your database details in properties file.
-  If you configured more than this two databases in properties file, You may have to configure the same in **TenantRoutingDataSource.java** and
- Run the application

In this application we have two end points. One for user signup and one for user login.

## **Testing**
For testing you can use **Postman** or any other rest API clients.

1. Default tenant

`URL` : <http://localhost:8080/multitenant/signup>

**Request Body**

    {
       "password": "Test1234",
       "phoneHash": "8787676767"
    }

**Response Body**

    {
      "lastLogin": "2022-04-10T06:09:30.319+00:00",
      "createdOn": "2022-04-10T06:09:29.561+00:00",
      "phoneHash": "8129388631"
    }
![](https://raw.githubusercontent.com/shuraif/images/main/SignupSuccesRequest.png)

2. Tenant-1

To test tenant-1 we can use same URL and request. To identify the tenant we are going to pass the tenant id in the request header.So we need to add a request header.

`X-Tenant-Id : tenant_1`

![](https://raw.githubusercontent.com/shuraif/images/main/SignupSuccess.png)


[Click Here][id/name]  for more reference

[id/name]: https://medium.com/swlh/multi-tenancy-implementation-using-spring-boot-hibernate-6a8e3ecb251a
