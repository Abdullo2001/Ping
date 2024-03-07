# Ping

## Prerequisites

- Spring Boot 3.x
- JDK 17
- Maven 4.x

## API Reference

#### Get all items

```http
  GET /ping
```

#### Get Search item by checkDate

```http
  GET /ping/check
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `checkDate`      | `string` | **Required**. checkDate of item to fetch |

#### Get Search item by checkDate

```http
  GET /ping/{ipOrDomen}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `ipOrDomen`      | `string` | **Required**. ipOrDomen of item to fetch |

#### Get Search item by checkDate

```http
  DEL /delete/id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. id of item to fetch |

#### Get Search item by checkDate

```http
  POST /ping
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `ipOrDomen`,`checkDate`,`status`,`result`      | `string` | **Required**. all proparties of item to fetch |

#### Get Search item by checkDate

```http
  GET /ping/pagination/{offset}/{pageSize}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `offset`,`pageSize`      | `int`,`int` | **Required**. number of elements and page number |





