# Restaurant app

App to manage menu, orders and customers for a restaurant.

My first app using spring boot 3 and gradle.

## Build and run

I will use docker and docker-compose.

1. Clone the repository

```bash
git clone yersonargote/restaurant && cd restaurant
```

2. Load env variables

```bash
source .env
```

*Note*: The environment variables needed are in `docker-compose.yml` and `application.yml`.

3. Build app

```bash
DOCKER_BUILDKIT=1 docker build -t yersonargote/restaurant . 
```

4. Run app

```bash
docker-compose up
```

Shutdown the app do `docker-compose down`

## API

### Auth

**Register user**

POST request `localhost:8080/api/v1/auth/register`

*Body request example*:

```json
{
  "username": "test",
  "password": "test"
}
```

**Login**

POST request `localhost:8080/api/v1/auth/login`

*Body request example*:

```json
{
  "username": "test",
  "password": "test"
}
```

# Todo list

### Security and Auth
- [x] Register user
- [x] Login
    - [x] Oauth2 with GitHub
- [x] Logout
- [ ] Redirect to page when login
 
### Dinning Room
- [x] Create entities
- [x] Relationships between entities
- [x] Create repositories
- [x] Create services
- [x] Create controllers

# Native Compilation

1. Native images with spring boot and gradle

Install plugin.

```yaml
plugins {
  id 'org.graalvm.buildtools.native' version '0.9.14'
}
```

```bash
./gradlew nativeCompile
```

# Commands

- To run the app using only console

```bash
./gradlew bootRun
```

- To compile a native image in a container

```bash
./gradlew bootBuildImage --imageName=yersonargote/restaurante
```

- To compile app

```bash
./gradlew nativeCompile
```

- To have AOT optimized app
```bash
./gradlew bootJar
```

# Resources

[Spring Security, demystified by Daniel Garnier Moiroux](https://youtu.be/iJ2muJniikY)

[Spring boot 3.0 - Secure your API with JWT Token 2023](https://youtu.be/BVdQ3iuovg0)

[Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)