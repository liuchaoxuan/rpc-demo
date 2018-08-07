package com.zg.kyrie.server.app;

import com.zg.kyrie.server.request.CalculateRpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: kyrie
 * @Date: 2018/8/7 22:15
 */
public class ProviderApp {
    public static void main(String[] args) {
        try {
            new ProviderApp().run();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void run() throws Exception {
        ServerSocket listener = new ServerSocket(8888);
        while (true){
            Socket socket = listener.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object object = inputStream.readObject();
            int result = 0;
            if (object instanceof CalculateRpcRequest){
                CalculateRpcRequest calculateRpcRequest = (CalculateRpcRequest) object;
                if (((CalculateRpcRequest) object).getMethod().equals("add")){
                    result = calculateRpcRequest.getA() + calculateRpcRequest.getB();
                }
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(new Integer(result));
        }
    }
}
