package com.alihmzyv.logservice.server;

import com.alihmzyv.logservice.proto.CreateLogRequest;
import com.alihmzyv.logservice.proto.LogResponse;
import com.alihmzyv.logservice.proto.LogServiceGrpc;
import com.alihmzyv.logservice.service.LogService;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.lognet.springboot.grpc.GRpcService;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@GRpcService
public class LogGrpcService extends LogServiceGrpc.LogServiceImplBase {
    LogService logService;

    @Override
    public void createLog(CreateLogRequest request, StreamObserver<LogResponse> responseObserver) {
        try {
            LogResponse logResponse = logService.createLog(request);
            responseObserver.onNext(logResponse);
        } finally {
            responseObserver.onCompleted();
        }
    }
}
