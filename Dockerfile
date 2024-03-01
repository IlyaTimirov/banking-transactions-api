FROM openjdk:17
ADD /target/banking-transactions-0.0.1-SNAPSHOT.jar bankingTransactions.jar
ENTRYPOINT ["java", "-jar", "bankingTransactions.jar"]