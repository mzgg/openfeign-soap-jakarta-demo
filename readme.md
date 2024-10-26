# OpenFeign SOAP Integration Demo with Jakarta

This project demonstrates how to call a SOAP web service using OpenFeign in a Spring Boot 3 application with Java 21. The implementation is clean, relying on Feign's flexibility and configuration power to set up a SOAP client. Below are detailed instructions and configurations for setting up and running the project.

## Prerequisites

- Java 21
- Spring Boot 3.3.5
- Maven

## Generating SOAP Client Stubs

The project uses the `jaxws-maven-plugin` to generate SOAP client stubs from the WSDL file. This plugin automates the generation of necessary classes under the `target` directory, making the setup and request handling simpler.

To use the plugin, include the following configuration in your `pom.xml` file:

```xml
<plugin>
    <groupId>com.sun.xml.ws</groupId>
    <artifactId>jaxws-maven-plugin</artifactId>
    <version>4.0.2</version>
    <executions>
        <execution>
            <goals>
                <goal>wsimport</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <wsdlDirectory>${project.basedir}/src/main/resources/</wsdlDirectory>
        <wsdlUrls>
            <wsdlUrl>http://www.dneonline.com/calculator.asmx?wsdl</wsdlUrl>
        </wsdlUrls>
        <packageName>com.example.calculator</packageName>
        <sourceDestDir>${project.build.directory}/generated-sources/</sourceDestDir>
    </configuration>
</plugin>
```

### Notes:
- The WSDL URL is specified as `http://www.dneonline.com/calculator.asmx?wsdl`.
- The generated request and response classes are outputted to `target/generated-sources`.
- Copy these generated resources into the `feign/resource` directory within your project for consistent package organization.


## Dependencies

To enable seamless encoding and decoding in the Feign client, `feign-soap-jakarta` is used. Additionally, `spring-cloud-starter-openfeign` provides essential Feign client support in Spring Boot:

```xml

<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
        <version>4.1.3</version>
    </dependency>

    <dependency>
        <groupId>io.github.openfeign</groupId>
        <artifactId>feign-soap-jakarta</artifactId>
        <version>13.1</version>
    </dependency> 
</dependencies>

```

 
## Configuration

Feign client configurations offer a high degree of flexibility, allowing fine-tuning of connection and read timeouts, logging levels, and specific client URLs. Configurations can be set directly in `application.properties`:

```properties
spring.cloud.openfeign.client.config.calculator.url=http://www.dneonline.com/calculator.asmx
spring.cloud.openfeign.client.config.calculator.connect-timeout=5000
spring.cloud.openfeign.client.config.calculator.read-timeout=5000
spring.cloud.openfeign.client.config.calculator.logger-level=none
```


### Key Configuration Descriptions:
- `url`: Defines the endpoint URL for the SOAP service.
- `connect-timeout`: Sets the timeout for establishing connections.
- `read-timeout`: Sets the timeout for reading data from the service.
- `logger-level`: Sets the logging level. Options include:
    - `none`: Suppresses logging.
    - `basic`: Logs request method and URL, response status, and execution time.
    - `full`: Logs request and response headers, body, and metadata, providing a detailed view of request and response logs.

Using `full` for `logger-level` can be useful for debugging and verifying SOAP requests and responses in detail.


## Why Use Feign for SOAP?

Feign's integration with SOAP makes service calls more concise and manageable. It enables a more **clean** and **maintainable** structure, keeping the setup minimal while still allowing extensive configuration through properties and custom configurations.

## Conclusion

This demo demonstrates how to achieve a clean SOAP integration using OpenFeign with Jakarta in a Spring Boot application. Feign's flexibility ensures that configurations and SOAP service calls remain straightforward, making it an ideal choice for modern REST and SOAP integrations alike.
