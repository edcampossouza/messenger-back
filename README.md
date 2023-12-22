# Messages API

Spring Boot - Maven - JPA (mysql) api for a messaging app

## Requires 
 - Java 17
 - MySQL

## Configuration:
Set the following environment variables (or use a .env file)
 - API_PORT
 - DB_URL: _jdbc url for the mysql database_  */* database name
 - DB_USER
 - DB_PASSWORD

_read the provided .env.example file_
## Endpoints:
### Messages
```GET /messages?type=TYPE```
where ```type``` is ```received``` (default) or ```sent```

returns an array with all messages sent or received

example: 
```json
[
    {
        "createdAt": "2023-12-22T18:42:44.371+00:00",
        "messageId": 1,
        "text": "hello 2",
        "receiver": {
            "username": "user1",
            "userId": 1
        },
        "sender": {
            "username": "user2",
            "userId": 2
        }
    }
]

```

```POST /messages```

Posts a message. Request body format:

```json
{
    "receiverName": "admin",
    "text": "hello 2"
}
```
returns the created message

```json
{
    "message": {
        "createdAt": "2023-12-22T18:42:44.371+00:00",
        "messageId": 1,
        "text": "hello 2",
        "receiver": {
            "username": "admin",
            "userId": 1
        },
        "sender": {
            "username": "user1",
            "userId": 2
        }
    }
}
```

### Auth

```POST /auth/login```

Request body format:

```json
{
    "username": "user",
    "password": "my_strong_password"
}
```

Returns the user info and an authentication token

```json
{
  "token": "my_jwt_token",
  "user": {
    "userId": 1,
    "username": "admin",
    "authorities": [
      {
        "roleId": 1,
        "authority": "USER"
      }
    ],
    "enabled": true,
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true
  }
}
```

```POST /auth/signup```

Request body format:

```json
{
    "username": "user",
    "password": "my_strong_password"
}
```

Returns the user info and an authentication token (similar to ```POST /auth/signup```) above