SET TCP_CLIENT_TYPE=MultithreadedSocketServer
SET TCP_SERVER_PORT=1433
mvn clean package && mvn exec:java