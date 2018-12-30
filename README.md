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

By default this code start a server on localhost as host and 8080 as port, but if you want to change it, edit the code part where http server is being setup. Make the host as 0.0.0.0 to access the APIs publicly. 

Once you have done above changes, you can run the the code with following command in project directory
```
sbt run
```
It will download all the required libraries and then start running the code in your system, mysql db insertion might take a little time, so wait for the logging to say "Insertion over". After all the preprocessing is done, you'll see the message "Server online at http://public-ip:8080/  ....."
Once server has started, you can access the APIs in your web-browser. API details are given in next section

## API details
This project provides 5 APIs to get the bitcoin prices and see next 15 days prediction

### 1
This API provides the bitcoin price of last week

http://host:8080/lastWeekPrice

### 2
This API provides the bitcoin price of last week

http://host:8080/lastWeekPrice

### 3
This API provides the bitcoin price between two custom dates(dates should be in 'YYYY-MM-DD' format)

http://host:8080/customPrice?start=2018-06-14&end=2018-06-18

### 4
This API provides the n days moving average between two custom dates

http://host:8080/movavg?start=2018-06-10&end=2018-06-18&n=2

### 5
This API provides the next 15 days prediction of the bitcoin price (ARIMA model has been used for it)

http://host:8080/predictPri