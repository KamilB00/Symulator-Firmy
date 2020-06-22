# Symulator Firmy / Company Simulation

This simulation visualize statistics : 
- generated income 
- comparison between costs and profits
- number of realized orders
- number of orders in process
- employees positions in company
- responsive bank and credit data
- taxes and deducted tax value
- number of working project groups
- efficiency of working team and anticipated product deployment time
- products each team is working on
- company shares graph 

# CONFIGURATION
**SQL DATA BASE**
  
```console
$ mysql -u -root -p

```
> Enter your mysql password

```console
$ CREATE DATABASE simulationDataBase; 

```
> **Note:** Data base has been created
```console
$ USE simulationDataBase;

```
> **Note:** Choosing proper data base we want to use

```console
$ CREATE TABLE worker( ID INT PRIMARY KEY NOT NULL,  EFFICIENCY REAL NOT NULL, POSITION TEXT NOT NULL, SALARY REAL NOT NULL); 

```
> **Note:** Creating table with required values 
```console
$ CREATE USER ’admin’@’localhost’ IDENTIFIED BY ’pass’;

```
> **Note:** creating user: admin,  password: pass
```console
$ GRANT ALL PRIVILEGES ON simulationDataBase.* TO ’admin’@’localhost’ WITH GRANT OPTION;

```
> **Note:** granting privileges on created user

**JAVA**
- SDKs 11.0.7
- Maven 11
- Java compiler 11

# Tech

- JavaFX
- Hibernate 
- MySQL
- JFoenix 
- CSS

# About Project

Simulation gives insight into business world and shows estimated numbers which come with delivering software services. In this particular example we have created **simulation of software house**, where you can specify number of **programmers**, **marketers**, **accountants** and **project managers**. It allows users to verify if the number of people which was chosen meet their expectations. Every person created in this program has randomly assigned properties: id, salary, availability, efficiency, position, group. All properties are randomized in reasonable bounds however, availability is set always on TRUE.


![form_gif](https://user-images.githubusercontent.com/57325544/85229989-6cab2d00-b3ed-11ea-80fc-8e5c01cdc85e.gif)

Pre simulation form requires from users to specify: **simulation time** (in years), **number of orders which company can realize at the same time**, **number of employees on different positions**, **way of financing the company**. 
There are four ways of initial financing a business: **Credit**, **Investor**, **Venture Capitals**, **Own Capital**. 
 
<img width="352" alt="Zrzut ekranu 2020-06-21 o 13 33 14" src="https://user-images.githubusercontent.com/57325544/85229922-11793a80-b3ed-11ea-817d-8d5c556d0fc7.png">

Picking one and accepting conditions we are ready to start simulation. If the user want to change way of financing, the conditions needs to be accepted again.:
- **Credit** minimal amount is based on numer of employees we have chosen. If the costs of employees are lower than 100.000PLN the minimal amount to take is 100.000
- **Investor** randomly generated time (in years) of taking random percent from profits
- **Own Capital** the user can put here a number higher than 100.000 PLN
- **Venture Capitals** taking random percent of company shares and generates random amount of money

<img width="491" alt="Zrzut ekranu 2020-06-21 o 13 33 51" src="https://user-images.githubusercontent.com/57325544/85229942-2e157280-b3ed-11ea-9f79-2ae388ad3423.png">

> Example of "Venture Capitals" conditions form

**Simulation screen** appears after correct form fill in. **Timer** visible in the left corner takes current date and add the duration time. **Progress bar** (on the top) represent expired time. Choosing different financing forms is also noticeable during simulation. **Bank** is turned on  only if user choose "credit", otherwise bank icons are blank. Installments are being paid every month, only if company budget is positive. In case the budget drops below zero and it comes to payoff, bank charges **5%**   interest from taken amount on every delayed month. When company budget raise up again, the installment is being paid with all charged interest.  
![simulation_gif](https://user-images.githubusercontent.com/57325544/85229976-5ac98a00-b3ed-11ea-8881-0c9fa2102f64.gif)
**Working Teams** - every worker is assigned automatically to the group, which realize orders. Program generates orders with parameters: **level of difficulty**, **time to accomplish**, **price**. Value of last two parameters is based on difficulty level. **Number of working groups** is equal to orders realizing in the same time number (one team one order)  provided by user. After finishing an order, group is set as **free** and program assign new order to it.   **Group efficiency** is measured by sum of efficiencies its members. 

![Zrzut ekranu 2020-06-22 o 12 46 55](https://user-images.githubusercontent.com/57325544/85279313-851b5600-b486-11ea-8713-40bf770f32b7.png)

<img width="401" alt="Zrzut ekranu 2020-06-21 o 13 34 15" src="https://user-images.githubusercontent.com/57325544/85229960-45ecf680-b3ed-11ea-8169-f15ff16b9153.png">

>  **Note**: Statistics could change while using different types of financing

**Data Base** provides information about created employees. Every application launch delete information from data base and update it with new one.

<img width="627" alt="Data Base " src="https://user-images.githubusercontent.com/57325544/85229660-6320c580-b3eb-11ea-85e1-7094cf7ac872.png">



# Authors
* KamilB00 - **Kamil Bońkowski** (Backend, Frontend) 
* TROLLSTEFAN - **Kuba Dębowski** (Frontend, Documentation) 
* matt1easy  - **Mateusz Chalik** (Frontend, Documentation) 
* andbob885 - **Tomasz Bober** (Frontend, Documentation) 















