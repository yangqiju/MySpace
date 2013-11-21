//package com.joyveb.java7.aio.test;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.net.NetworkInterface;
//import java.net.SocketAddress;
//import java.net.StandardProtocolFamily;
//import java.net.StandardSocketOption;
//import java.nio.ByteBuffer;
//import java.nio.channels.AsynchronousChannelGroup;
//import java.nio.channels.AsynchronousDatagramChannel;
//import java.nio.channels.CompletionHandler;
//import java.nio.channels.MembershipKey;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class AsynchronousDatagramChannelExample {
//    
//    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
//        new AsynchronousDatagramChannelExample();
//    }
//    
//    public AsynchronousDatagramChannelExample() throws IOException, InterruptedException, ExecutionException {
//        // find a NetworkInterface that supports multicasting
//        NetworkInterface networkInterface = NetworkInterface.getByName("eth0");
//        
//        // create a custom channel group to use
//        AsynchronousChannelGroup tenThreadGroup = AsynchronousChannelGroup.withFixedThreadPool(10, Executors.defaultThreadFactory());
//        
//        // specify an arbitrary port and address in the range
//        int port = 5239;
//        InetAddress group = InetAddress.getByName("226.18.84.25");
//        
//        System.out.println("Create client channel on port " + port);
//        // the channel should be opened with the appropriate protocol family
//        // use the defined channel group or pass in null to use the default channel group
//        final AsynchronousDatagramChannel client = AsynchronousDatagramChannel.open(StandardProtocolFamily.INET, tenThreadGroup);
//        // enable binding multiple sockets to the same address
//        client.setOption(StandardSocketOption.SO_REUSEADDR, true);
//        // bind to the port
//        client.bind(new InetSocketAddress(port));
//        // set the interface for sending datagrams
//        client.setOption(StandardSocketOption.IP_MULTICAST_IF, networkInterface);
//        
//        System.out.println("Joining multicast group " + group + " on network interface " + networkInterface);
//        // join the multicast group
//        MembershipKey key = client.join(group, networkInterface);
//        
//        // open another channel to act as the server
//        AsynchronousDatagramChannel server = AsynchronousDatagramChannel.open().bind(null);
//        System.out.println("Create server channel with address " + server.getLocalAddress());
//        
//        // send message
//        System.out.println("Sending datagram packet to group " + group + " on port " + port);
//        ByteBuffer message = ByteBuffer.wrap("Hello to all listeners".getBytes());
//        server.send(message, new InetSocketAddress(group, port));
//        
//        // receive message
//        final ByteBuffer buffer = ByteBuffer.allocate(100);
//        client.receive(buffer, null, new CompletionHandler<SocketAddress, Object>() {
//            @Override
//            public void completed(SocketAddress address, Object attachment) {
//                System.out.println("Message received from address " + address + ": " + new String(buffer.array()));
//                clearUp();
//            }
//
//            @Override
//            public void failed(Throwable e, Object attachment) {
//                System.err.println("Error receiving datagram");
//                e.printStackTrace();
//                clearUp();
//            }
//            
//            private void clearUp() {
//                try {
//                    client.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        
//        
//        // tidy up, wait for
//        tenThreadGroup.shutdown();
//        tenThreadGroup.awaitTermination(1, TimeUnit.MINUTES);
//        key.drop();
//        server.close();
//    }
//}
