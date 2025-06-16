# Environment Variables

## Database Configuration
- `POSTGRES_DB`: The name of the PostgreSQL database to use (e.g., `hestix_db`).
- `POSTGRES_USER`: The PostgreSQL user for authentication (e.g., `hestix_user`).
- `POSTGRES_PASSWORD`: The password for the PostgreSQL user.

## Keycloak Configuration
- `KEYCLOAK_URL`: The URL of the Keycloak authentication server (e.g., `http://localhost:8080`).
- `KEYCLOAK_ADMIN`: The admin username for Keycloak.
- `KEYCLOAK_ADMIN_PASSWORD`: The password for the Keycloak admin user.
- `CLIENT_SECRET`: The client secret used for your Keycloak client.

## JWT Configuration (required for JWT validation)
- `JWT_ISSUER_URI`: The URI used to verify JWT tokens (e.g., `http://localhost:8080/realms/dev`).

## Backend Configuration
- `SERVER_PORT`: The Port which the backend will run on (default `9090`).

## Build Profile Configuration
- `BUILD_PROFILE`: Determines the build mode (options: `dev`, `prod`).

## Example `.env` File
Here’s an example `.env` file for your backend configuration:

```plaintext
POSTGRES_DB=hestix_db
POSTGRES_USER=hestix_user
POSTGRES_PASSWORD=your_secure_password_here
KEYCLOAK_URL=http://localhost:8080
KEYCLOAK_ADMIN=admin
KEYCLOAK_ADMIN_PASSWORD=your_secure_admin_password_here
CLIENT_SECRET=your_client_secret_here
JWT_ISSUER_URI=http://localhost:8080/realms/dev
SERVER_PORT=9090
BUILD_PROFILE=dev
