<p>url: http://localhost:8080/api</p>

<h2>application.properties</h2>
<p>
spring.application.name=CodeReviewNovaServe
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.generate-unique-name=false
spring.datasource.name=cars
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
</p>

Default username = "sa"
Default password = ""

<h2>schema.sql</h2>
<p>
CREATE TABLE IF NOT EXISTS review_cars (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           brand VARCHAR(255) NOT NULL,
                                           model VARCHAR(255) NOT NULL,
                                           weight DOUBLE NOT NULL,
                                           height DOUBLE NOT NULL,
                                           width DOUBLE NOT NULL,
                                           color VARCHAR(255) NOT NULL,
                                           engine_capacity DOUBLE NOT NULL
);
</p>