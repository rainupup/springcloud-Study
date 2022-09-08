package cn.rainupup.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class testBlockHandler {
    public static String testBlock1(BlockException exception){
        return ":(";
    }

    public static String testBlock2(BlockException exception){
        return ":(";
    }
}
