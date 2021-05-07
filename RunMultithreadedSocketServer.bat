SET TCP_CLIENT_TYPE=MultithreadedSocketServer
SET TCP_SERVER_PORT=1433
SET TCP_RESPONSE_DELAY_IN_SECONDS=10
mvn clean package && mvn exec:java