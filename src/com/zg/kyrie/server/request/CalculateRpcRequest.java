package com.zg.kyrie.server.request;

import java.io.Serializable;

/**
 * @Auther: kyrie
 * @Date: 2018/8/7 22:11
 */
public class CalculateRpcRequest implements Serializable {
    private int A;
    private int B;
    private String method;

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "CalculateRpcRequest{" +
                "A=" + A +
                ", B=" + B +
                ", method='" + method + '\'' +
                '}';
    }
}
