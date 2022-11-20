# City-Locator-Backend

This application exposes rest end point to update and search an image.

Steps:

1) mvn clean install
2) This is spring boot application so it can be started with file SpringBootCityApplication.
2) Outh authentication is impletented into the same application but its not used for frond end and this part is commented for now.
3) if we want to enable authentication for backend, please uncomment below code.

OAuth2ResourceServerConfig:
![image](https://user-images.githubusercontent.com/65996920/202890668-5e1d8ca1-bd93-40b0-8500-aeb8de6ba21c.png)

OauthSecurityConfiguration:
![image](https://user-images.githubusercontent.com/65996920/202890689-cf97dd36-0391-4618-a804-f0ddb1e04520.png)
