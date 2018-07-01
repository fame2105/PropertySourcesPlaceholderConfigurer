# PropertySourcesPlaceholderConfigurer
Read values from external properties file 
we need to configure the PropertySourcesPlaceholderConfigurer only when we are reading the values from external property file, 
Incase you want to read the values from application.properties in springBoot then you don't need to configure anything.
Just define the properties in application.properties and set it onto a variable using @Value("${}") annotation.
