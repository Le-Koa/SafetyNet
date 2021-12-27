# SafetyNet

SafetyNet Alerts is an application helping to get informations for public services such as emergency service

# Prerequisites

Java 15

# Usefull link

http://localhost:8080/person

http://localhost:8080/medicalRecord

http://localhost:8080/person?firstName=Jacob&lastName=Boyd

http://localhost:8080/medicalRecord?firstName=Jacob&lastName=Boyd


http://localhost:8080/firestation?stationNumber=1

http://localhost:8080/childAlert?address=1509%20Culver%20St

http://localhost:8080/phoneAlert?firestation=1

http://localhost:8080/fire?address=1509%20Culver%20St

http://localhost:8080/flood?stations=1,2

http://localhost:8080/personInfo?firstName=John&lastName=Boyd

http://localhost:8080/communityEmail?city=Culver

# Run tests

mvn test

# Run site

mvn site
