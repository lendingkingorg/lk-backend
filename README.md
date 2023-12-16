
# lk-backend 

Backend codebase for LendingKing application.






## Run Locally

Install Java, Eclipse IDE and PostgreSQL on your system.

Steps to set-up the project in Eclipse:

```bash
    git clone https://github.com/lendingkingorg/lk-backend.git

    Open Eclipse and create a workspace at your desired location.

    Go to File->Import->Maven->Exsisting Maven Projects

    Select lk-backend cloned directory and verify the pom.xml file 
    listed below is the file coming from lk-backend folder.

    Select finish.

Note: When you are running the application for the first time leave it 
idle at this stage for 3-5 minutes for the dependecies to get installed
```

Starting the server:
```bash
    Open the LkBackendApplication.java inside src/main/java folder.

    Right click inside the file and select Run As -> Java Application.

    A server must be started at port 8080. Go to localhost:8080, it should 
    ask you for a username and password which you can find in the application 
    properties file inside src/main/resources folder.

