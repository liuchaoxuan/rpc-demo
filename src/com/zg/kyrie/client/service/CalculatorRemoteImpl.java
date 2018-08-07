package com.zg.kyrie.client.service;

import com.zg.kyrie.server.request.CalculateRpcRequest;
import com.zg.kyrie.server.service.Calculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Auther: kyrie
 * @Date: 2018/8/7 23:01
 */
public class CalculatorRemoteImpl implements Calculator {
    public int add(int a, int b) {
        CalculateRpcRequest calculateRpcRequest = new CalculateRpcRequest();
        calculateRpcRequest.setA(a);
        calculateRpcRequest.setB(b);
        calculateRpcRequest.setMethod("add");
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(calculateRpcRequest);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object = objectInputStream.readObject();
            if (object instanceof Integer){
                return (Integer) object;
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
