1. **Description**

  It is a project that implements back-end logic. The main purpose of the appication is to allow the user to join for the lecture path during software conference. The entire project was build using the REST architecture. There are few entities based on SQL relations.
  
Main assumptions:
* The conference  day is set to 1.06.2021
* Lecture starts at 10:00 and finishes at 15:45
* Every lecture path is taking 1h 45 minutes
* The conference supports 3 different thematic tracks run in parallel
* If a user writes to a particular path for a given time, it is no longer allowed to attend in another path during that period, but at another time
* Each lecture path can hold up to 5 listeners

  **Access data set in pplication.properties:**
 
  user: sa password: password

2. **Demo**

  Project is only available at this repository at this moment.
  
3. **Requirements**
* Java 8
* Spring Boot 2.5.1
* H2 dataBase
* Maven
* Lombok 1.18.20

4. **StartUp**
Project can be launched locally by executing SpringbootConferenceApplication class, which starts up the Spring ApplicationContext. While on it can be accesed via local address.

![image](https://user-images.githubusercontent.com/77328749/124913444-69caac80-dfef-11eb-9ddd-920f1aa67de9.png)

5. **EndPoint's description**

![image](https://user-images.githubusercontent.com/77328749/124915338-b57e5580-dff1-11eb-9545-93854e7f1a69.png)

6. **Application**
  At this stage, project can operate with simple operations like:
  
* Find user's
* Find user by ID
* Create user
* Create reservation
* Update user's e-mail
* Update user's data
* Cancel reservation
* Get conference plan
 
 Future development:
 
 *Prepare test's using:
 
  @WebMvcTest(XXX.class)
  
  @SpringJUnitWebConfig
