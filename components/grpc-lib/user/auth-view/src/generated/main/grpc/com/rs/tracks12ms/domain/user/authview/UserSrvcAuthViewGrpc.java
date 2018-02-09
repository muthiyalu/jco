package com.rs.tracks12ms.domain.user.authview;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: userauthview.proto")
public final class UserSrvcAuthViewGrpc {

  private UserSrvcAuthViewGrpc() {}

  public static final String SERVICE_NAME = "com.rs.tracks12ms.domain.user.authview.UserSrvcAuthView";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rs.tracks12ms.domain.user.authview.UserAuthRequest,
      com.rs.tracks12ms.domain.user.authview.UserAuthView> METHOD_ADD_USER =
      io.grpc.MethodDescriptor.<com.rs.tracks12ms.domain.user.authview.UserAuthRequest, com.rs.tracks12ms.domain.user.authview.UserAuthView>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.rs.tracks12ms.domain.user.authview.UserSrvcAuthView", "addUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rs.tracks12ms.domain.user.authview.UserAuthRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rs.tracks12ms.domain.user.authview.UserAuthView.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rs.tracks12ms.domain.user.authview.UserAuthQuery,
      com.rs.tracks12ms.domain.user.authview.UserAuthView> METHOD_SEARCH_USER_BY_NAME =
      io.grpc.MethodDescriptor.<com.rs.tracks12ms.domain.user.authview.UserAuthQuery, com.rs.tracks12ms.domain.user.authview.UserAuthView>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.rs.tracks12ms.domain.user.authview.UserSrvcAuthView", "searchUserByName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rs.tracks12ms.domain.user.authview.UserAuthQuery.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rs.tracks12ms.domain.user.authview.UserAuthView.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserSrvcAuthViewStub newStub(io.grpc.Channel channel) {
    return new UserSrvcAuthViewStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserSrvcAuthViewBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserSrvcAuthViewBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserSrvcAuthViewFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserSrvcAuthViewFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class UserSrvcAuthViewImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void addUser(com.rs.tracks12ms.domain.user.authview.UserAuthRequest request,
        io.grpc.stub.StreamObserver<com.rs.tracks12ms.domain.user.authview.UserAuthView> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_USER, responseObserver);
    }

    /**
     */
    public void searchUserByName(com.rs.tracks12ms.domain.user.authview.UserAuthQuery request,
        io.grpc.stub.StreamObserver<com.rs.tracks12ms.domain.user.authview.UserAuthView> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_USER_BY_NAME, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_USER,
            asyncUnaryCall(
              new MethodHandlers<
                com.rs.tracks12ms.domain.user.authview.UserAuthRequest,
                com.rs.tracks12ms.domain.user.authview.UserAuthView>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            METHOD_SEARCH_USER_BY_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                com.rs.tracks12ms.domain.user.authview.UserAuthQuery,
                com.rs.tracks12ms.domain.user.authview.UserAuthView>(
                  this, METHODID_SEARCH_USER_BY_NAME)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class UserSrvcAuthViewStub extends io.grpc.stub.AbstractStub<UserSrvcAuthViewStub> {
    private UserSrvcAuthViewStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserSrvcAuthViewStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserSrvcAuthViewStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserSrvcAuthViewStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void addUser(com.rs.tracks12ms.domain.user.authview.UserAuthRequest request,
        io.grpc.stub.StreamObserver<com.rs.tracks12ms.domain.user.authview.UserAuthView> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchUserByName(com.rs.tracks12ms.domain.user.authview.UserAuthQuery request,
        io.grpc.stub.StreamObserver<com.rs.tracks12ms.domain.user.authview.UserAuthView> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_USER_BY_NAME, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class UserSrvcAuthViewBlockingStub extends io.grpc.stub.AbstractStub<UserSrvcAuthViewBlockingStub> {
    private UserSrvcAuthViewBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserSrvcAuthViewBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserSrvcAuthViewBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserSrvcAuthViewBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.rs.tracks12ms.domain.user.authview.UserAuthView addUser(com.rs.tracks12ms.domain.user.authview.UserAuthRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_USER, getCallOptions(), request);
    }

    /**
     */
    public com.rs.tracks12ms.domain.user.authview.UserAuthView searchUserByName(com.rs.tracks12ms.domain.user.authview.UserAuthQuery request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_USER_BY_NAME, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class UserSrvcAuthViewFutureStub extends io.grpc.stub.AbstractStub<UserSrvcAuthViewFutureStub> {
    private UserSrvcAuthViewFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserSrvcAuthViewFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserSrvcAuthViewFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserSrvcAuthViewFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rs.tracks12ms.domain.user.authview.UserAuthView> addUser(
        com.rs.tracks12ms.domain.user.authview.UserAuthRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rs.tracks12ms.domain.user.authview.UserAuthView> searchUserByName(
        com.rs.tracks12ms.domain.user.authview.UserAuthQuery request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_USER_BY_NAME, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_USER = 0;
  private static final int METHODID_SEARCH_USER_BY_NAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserSrvcAuthViewImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserSrvcAuthViewImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_USER:
          serviceImpl.addUser((com.rs.tracks12ms.domain.user.authview.UserAuthRequest) request,
              (io.grpc.stub.StreamObserver<com.rs.tracks12ms.domain.user.authview.UserAuthView>) responseObserver);
          break;
        case METHODID_SEARCH_USER_BY_NAME:
          serviceImpl.searchUserByName((com.rs.tracks12ms.domain.user.authview.UserAuthQuery) request,
              (io.grpc.stub.StreamObserver<com.rs.tracks12ms.domain.user.authview.UserAuthView>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class UserSrvcAuthViewDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rs.tracks12ms.domain.user.authview.UserAuthViewProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserSrvcAuthViewGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserSrvcAuthViewDescriptorSupplier())
              .addMethod(METHOD_ADD_USER)
              .addMethod(METHOD_SEARCH_USER_BY_NAME)
              .build();
        }
      }
    }
    return result;
  }
}
