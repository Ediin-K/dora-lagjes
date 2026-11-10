# dora-lagjes
Digital platform connecting residents with their municipality: notices, complaints, polls and neighbourly help.

## Structure

```
dora-lagjes/
├── backend/                     Spring Boot backend (Java 17, Maven)
│   ├── pom.xml
│   └── src/main/java/com/doralagjes/dora_lagjes/
│       ├── config/              CORS / web config
│       ├── controller/          REST endpoints (/api/...)
│       ├── dto/                 Request objects with validation
│       ├── exception/           Error handling
│       ├── model/               JPA entities
│       ├── repository/          Spring Data repositories
│       └── service/             Business logic
│   └── src/main/resources/application.properties
└── frontend/                    React app (Vite)
    └── src/
        ├── api/                 fetch client for the backend
        ├── components/          shared UI (Layout)
        └── pages/               route pages (Notices, Complaints)
```

## Running (development)

Backend (http://localhost:8080, H2 in-memory DB, console at `/h2-console`):

```bash
cd backend
./mvnw spring-boot:run
```

Frontend (http://localhost:5173, proxies `/api` to the backend):

```bash
cd frontend
npm install
npm run dev
```

## API

| Method | Path                           | Description            |
|--------|--------------------------------|------------------------|
| GET    | `/api/notices`                 | List notices           |
| POST   | `/api/notices`                 | Create notice          |
| DELETE | `/api/notices/{id}`            | Delete notice          |
| GET    | `/api/complaints`              | List complaints        |
| POST   | `/api/complaints`              | Create complaint       |
| PATCH  | `/api/complaints/{id}/status`  | `?status=OPEN\|IN_PROGRESS\|RESOLVED` |
