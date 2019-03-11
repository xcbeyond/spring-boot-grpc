package com.xcbeyond.springboot.grpc.server.service;

import com.xcbeyond.springboot.grpc.lib.HelloReply;
import com.xcbeyond.springboot.grpc.lib.HelloRequest;
import com.xcbeyond.springboot.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @Auther: xcbeyond
 * @Date: 2019/3/6 18:15
 */
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("GrpcServerService...");
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}