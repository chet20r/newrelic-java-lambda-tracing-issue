package org.acme;

import com.amazonaws.services.lambda.runtime.Context;
import com.newrelic.opentracing.LambdaTracer;
import com.newrelic.opentracing.aws.StreamLambdaTracing;
import io.opentracing.util.GlobalTracer;
import io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GreetingLambdaStreamHandler extends QuarkusStreamHandler {
    static {
        GlobalTracer.registerIfAbsent(LambdaTracer.INSTANCE);
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        StreamLambdaTracing.instrument(inputStream, outputStream, context, super::handleRequest);
    }
}
