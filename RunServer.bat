SET TCP_CLIENT_TYPE=Server
SET TCP_SERVER_PORT=8000
mvn clean package && mvn exec:java