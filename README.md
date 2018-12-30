# Bitcoin project
This project is part of an assignment. It has set of REST APIs to see the historical prices of bitcoin prices and also predicts the next 15 days price.

## Project Information
Language  : Scala      <br />
Database  : Mysql


### Setup
This is a sbt based scala project, so you need to have sbt and scala sdk installed on your system. And java is also required as scala uses jvm. The scala file contains the configration parameter which one can change as per the requirement


### Steps to setup run environment(one time procedure):
1. Install java
2. Setup Scala
3. Setup sbt
4. Setup and start mysql server
5. Login to mysql server, create a database('mydatabase') and use following command to create the table
```
CREATE TABLE `bitcoin_price` (
  `time` date NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`time`)
)

```
Once done with all these steps, you are ready with an environment to run this project

## Running the project
As this project runs, it uses the file response.json in the project directory to insert the last 365 days bitcoin prices in mysql db. Use the following api from coinbase to get the latest 365 days data. Use it in browser to directly download response.json and put this file in the project directory

https://www.coinbase.com/api/v2/prices/BTC-USD/historic?period=year

By default this code start a server on localhost as host and 8080 as port.

Once you have done above changes, you can run the the code with following command in project directory
```
sbt run
```
It will download all the required libraries and then start running the code in your system.

## API details
This project provides 5 APIs to get the bitcoin prices and see next 15 days prediction

### 1. This API provides the bitcoin price of last week
http://localhost:8080/lastWeekPrice

### 2. This API provides the bitcoin price of last month. 
http://localhost:8080/lastMonthPrice

### 3. This API provides the bitcoin price between two custom dates (dates should be in 'YYYY-MM-DD' format)
http://localhost:8080/customPrice?start=2018-12-20&end=2018-12-28

### 4. This API provides the n days moving average between two custom dates (dates should be in 'YYYY-MM-DD' format)
http://localhost:8080/movavg?start=2018-12-15&end=2018-12-28&n=2

### 5. This API provides the next 15 days prediction of the bitcoin price (ARIMA model has been used for it)
http://localhost:8080/predictPrice


## Improvements
Aadvanced algorithms can be used to predict bitcoin prices.<br />
Logging mechanism can be enhanced.