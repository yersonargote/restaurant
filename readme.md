# Restaurant app

App to manage menu, orders and customers for a restaurant.

## Build and run

I will use docker and docker-compose.

1. Clone the repository

```git clone yersonargote/restaurant```

```cd restaurant```

2. Load env variables

```source .env```

*Note*: The environment variables needed are in `docker-compose.yml` and `application.yml`.

3. Build app

```DOCKER_BUILDKIT=1 docker build -t yersonargote/restaurant .``` 

4. Run app

```docker-compose up```

Shutdown the app do ```docker-compose down```

## API

### Auth

**Register user**

POST request ```localhost:8080/api/v1/auth/register```

*Body request example*:

```json
{
  "username": "test",
  "password": "test"
}
```

**Login**

POST request ```localhost:8080/api/v1/auth/login```

*Body request example*:

```json
{
  "username": "test",
  "password": "test"
}
```

## Todo list

- [x] Register user
- [x] Login
    - [x] Oauth2 with GitHub
- [ ] Logout
- [ ] Create daily menu
- [ ] Create orders
- [ ] Create tickets

# Commands

- To run the app using only console

```bash
./gradlew bootRun
```

- To compile a native image in a container

```bash
./gradlew bootBuildImage --imageName=yersonargote/restaurante
```