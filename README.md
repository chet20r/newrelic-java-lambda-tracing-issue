
Prerequisites
1. Docker
2. AWS SAM CLI

How to reproduce the issue

1. `./mvnw clean package`
2. `cp src/main/resources/sam.jvm.yaml target/`
3. `sam local start-api --template target/sam.jvm.yaml`

Now visit `localhost:3000/hello` which fails with exception

```text
[2,"NR_LAMBDA_MONITORING",{"agent_version":"2.1.1","protocol_version":16,"agent_language":"java","execution_environment":"AWS_Lambda_java11","arn":"","metadata_version":2},"H4sIAAAAAAAAAMVVbW\/aMBD+K5U1qVRKswRIAnyrtKqrtFVT6bQPFCFjH9QlsZnj0DHEf9855q0tULZW68ec7567e567y4zkYyp7MAFpepwaSlodWaSpNyOlLe\/lAJK0Qo9oyEFPlNC9XPwGNM29TmdGeKGpEQp9Aj8Ik2ZS84jRlMElJy0CcRTWkjChUdAfxElMPCJphtHkjkqewjX8LCA3aB4WwgbU6oM4guqgwePBgEYMX8x0bAPaWCh+MWpgqPQULUOQoIV1GWuhtDBoDP0oboRB1SM5zcYpIKbRBWBa7WM\/evpNCWmWRixU5pTZ+sty4wD6AcWS67VBnXNus4sMC0QsxI6DBNHjMIyCxhwpog+5n9Ksz6lPNTJA0H\/DxlTK24bqVTr7pl3HZTo6aDagH9ZPg2oQnNZDBqd9zvEziYIgqbKozmsEE8273a5HQGul\/69U2t9g6MIptIWjsjIfecrp0Ep1LJSvxpZuyoQc+m2GX0dPjDc2s\/Yt9gQ1tfJWnsah7eR4lYClNM8R\/p5OKHKMDleqXbC7r2DuFD+3PutB2ialG6SbdUvLmI0ur8rxLIk9ZKy2joedDVfySEhbzPkvBuOS+pWaVNJ0agR7h91zzf0NTztWrOxxycQhxLzj3mwS3OmsS\/IcG28+snuHdEYKFPTMGC36hQEc6j0DQ\/BgaSFzwUq\/vQLvFvXFWcZEuL3SPKoKjSgiG\/XKrMgfuTVMZb6EBw2pYI96tzK1jQaafSmFvFnYsXZMkKHj4txXtnlZwlpRcIK1virHbvBa6MCVRhyWgX+hAQw+O18X97n8L2n\/0f+pss+zxK4uCi9l79Mcbj\/e8xGWZUDjpuP4DlJgxr\/ChZ2AG4YzxvBkKn2JKqDnRI0gqDiHI+fxJpiV73Ik1YM8aqtCMzgM8xOkMKS25X\/HXW3AEtRB7Qt3F2BVzbm9gwuevyjKQX9w3DukhTrbJXseu5iCJDo0V9VnNE13IjWaza1IZz\/abk783F6x60LaY1hZm93ERI1XRIfN6gvRGRqfRTWSE9LFpX52IPBSzv8A0kvnpA0KAAA="]
'io.opentracing.Scope io.opentracing.Tracer.activateSpan(io.opentracing.Span)': java.lang.NoSuchMethodError
java.lang.NoSuchMethodError: 'io.opentracing.Scope io.opentracing.Tracer.activateSpan(io.opentracing.Span)'
	at com.newrelic.opentracing.aws.StreamLambdaTracing.instrumentRequest(StreamLambdaTracing.java:50)
	at com.newrelic.opentracing.aws.StreamLambdaTracing.instrument(StreamLambdaTracing.java:31)
	at org.acme.GreetingLambdaStreamHandler.handleRequest(GreetingLambdaStreamHandler.java:20)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.base/java.lang.reflect.Method.invoke(Unknown Source)

END RequestId: af98eb14-0200-41ce-bdd4-0750072c54d3
```


# code-with-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `code-with-quarkus-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

Guide: https://quarkus.io/guides/rest-json
