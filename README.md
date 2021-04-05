# NWCS - Simple Java Socket Console Application

## How to use

### Download

Download the latest `FinalJarAndBatchFiles.zip` from GitHub Release.

### Unzip

Unzip the `FinalJarAndBatchFiles.zip` on your computer.

### Execute batch files

Execute batch files for specific situation.

**IMPORTANT**: The "thierryiseli-tcp-client-0.1.jar" must be in the same folder as the batch file.

#### Configuration

Check env variables in batch files to configure host, port or other things.

For example `ExecuteJarForClient.bat`:

```
SET TCP_CLIENT_TYPE=Client
SET TCP_SERVER_HOST=127.0.0.1
SET TCP_SERVER_PORT=8000
java -jar thierryiseli-tcp-client-0.1.jar
```

| ENV-Variables          | Description                                                                                                        | Example                                                           |
| ---------------------- | ------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------- |
| TCP_CLIENT_TYPE        | Set current tcp type (server or client).                                                                           | Server<br/>MultithreadedServer<br/>Client<br/>MultithreadedClient |
| TCP_SERVER_HOST        | For server types: not necessary.<br/>For client types: Host of server to connect.                                  | 127.0.0.1<br/>192.168.1.10                                           |
| TCP_SERVER_PORT        | For server types: Set port on current host which runs the server.<br/>For client types: Port of server to connect. | 8484<br/>1234                                                        |
| TCP_AMOUNT_OF_REQUESTS | Amount of requests which executes ONLY the MultithreadedClient                                                     | 1<br/>3<br/>10                                                    |
