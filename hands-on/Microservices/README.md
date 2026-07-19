# Spring Boot 3 + Spring Cloud

Run Eureka first, then account, loan, greet-service and api-gateway.

```bash
mvn clean package
mvn spring-boot:run
```

URLs:
- Eureka: http://localhost:8761
- Gateway greet: http://localhost:9090/greet
- Account: http://localhost:9090/accounts/00987987973432
- Loan: http://localhost:9090/loans/H00987987972342
