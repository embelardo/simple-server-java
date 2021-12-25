# SimpleServer Java
A simple server in Java to test remote debugging with Java Debug Wire Protocol (JDWP).

# Steps to create a remote debug session with SimpleServer

## A. For the Debuggee

1 Compile SimpleServer with all debug information.

```text
javac -g SimpleServer.java
```

2 Launch SimpleServer with JVM argument `-agentlib:jdwp`.

```text
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=localhost:56784 SimpleServer
```

The `-agentlib:jdwp` JVM argument with comma-separated key-value sub-options tells JVM to load the JDWP agent and wait for a socket connection on port 56784.

Sub-options:
- `transport=dt_socket` tells JDWP agent to use socket transport.
- `server=y` tells JVM to listen for a debugger to attach to it.
- `suspend=n` tells JVM to wait for debugger to attach before executing main class (defaults to 'y').
- `address=localhost:56784` tells JVM the debugger's hostname / ip address and connection port.

## B. For the Debugger

Any Java debugger that supports remote debugging should be able to start a session.

1 Connecting with Java Debugger (JDB)

```text
jdb -attach localhost:56784
```

2 Connecting with VS Code

- Open Run & Debug and create an attach configuration.

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch SimpleServer",
            "request": "launch",
            "mainClass": "SimpleServer"
        },
        {
            "type": "java",
            "name": "Attach SimpleServer",
            "request": "attach",
            "hostName": "localhost",
            "port": "56784"
        }
    ]
}
```

- Select the 'Attach SimpleServer' configuration and run it.

# References
- [Definitive Guide to Remote Java Debugging 2020 \[Rudick\]](https://bit.ly/32BAnja)
- [Java Application Remote Debugging 2021 \[Baeldung\]](https://bit.ly/32CakYQ)
- [Remote Debugging Java Applications With JDWP 2019 \[Anouti\]](https://bit.ly/3Eq2LSj)
- [Java Platform Debugger Architecture: Connection and Invocation Details - Java 11 \[Oracle\]](https://bit.ly/33LfHWj)