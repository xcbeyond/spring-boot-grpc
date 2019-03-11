package com.xcbeyond.springboot.grpc.client.service;

import com.xcbeyond.springboot.grpc.lib.HelloReply;
import com.xcbeyond.springboot.grpc.lib.HelloRequest;
import com.xcbeyond.springboot.grpc.lib.SimpleGrpc.SimpleBlockingStub;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @Auther: xcbeyond
 * @Date: 2019/3/7 09:10
 */
@Service
public class GrpcClientService {

    @GrpcClient("spring-boot-grpc-server")
    private SimpleBlockingStub simpleBlockingStub;

    public String sendMessage(String name) {
        try {
            HelloReply response = simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode();
        }
    }
}
