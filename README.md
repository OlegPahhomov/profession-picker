# sector chooser
#### Just pick your sector.


#### 1) You need postgres database
To start postgres server, go with cmd to it’s installation, bin folder and run:
pg_ctl.exe  -D ../data start

#### 2) You need to configure the datasource, it’s in 2 places:
pom.xml (under flyway plugin)
and application.properties	

#### 3) Fill database
To fill in database (if this fails, go back to step 2)
cmd in folder or IDE:
mvn clean install flyway:clean flyway:migrate
or just run Application.java (spring boots creates db by default)

#### 4) run Application.java in your favorite IDE