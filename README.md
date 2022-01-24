## Running the Application
Please run **TttCodingChallengeApplication.java** and open http://localhost:8080 in your browser.


## Contribute To Community Project
**Time to complete project: 12 hours**

The tables **Applications**, **Jobs** and **Volunteers** where all uploaded
to PostgreSQL via IntelliJ CSV import. These tables then individually generate JPAs.

Additional **JobApplications** and **ApplicantInfo** were created inorder to map the new values.

ProdHibernateUtil class is used to connect the SessionFactory with the required configurations
to connect to the database.

The DAO classes call the database and frame queries in order to map the values to the JPA classes.

The controller class (ApplicationController.java) then stores the data which is then called in the front-end HTML.
This is located under **resources/**

### Assumptions
- The table that was provided is not dynamically loaded and is loaded prior to the application startup.
- API connection will not be interrupted and therefore is not secured.
- All table values have a value and is not NULL

### Things that could have been improved upon
If I had more time I would have done the following improvements:
- More thorough JUnit tests
- A neater front-end
- More interactive front end
- Implement security for the API calls
