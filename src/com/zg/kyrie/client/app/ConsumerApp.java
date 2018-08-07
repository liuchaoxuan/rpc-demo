package com.zg.kyrie.client.app;

import com.zg.kyrie.client.service.CalculatorRemoteImpl;
import com.zg.kyrie.server.service.Calculator;

/**
 * @Auther: kyrie
 * @Date: 2018/8/7 23:11
 */
public class ConsumerApp {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorRemoteImpl();
        int result = calculator.add(3, 5);
        System.out.println(result);
    }
}
