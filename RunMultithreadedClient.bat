SET TCP_CLIENT_TYPE=MultithreadedClient
SET TCP_SERVER_HOST=127.0.0.1
SET TCP_SERVER_PORT=1433
mvn clean package && mvn exec:java