package org.seckill.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/9/4.
 */
public class IProcessDataTest {
    @Test
    public String hello(String name) throws Exception {
        System.out.println(name);
        return "hello : " + name;
    }

}