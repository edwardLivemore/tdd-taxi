package com.jiker.keju;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommonUtilTest {
    private CommonUtil commonUtil;

    @Test
    public void construct_test(){
        commonUtil = new CommonUtil();
        assertEquals(commonUtil.getDistanceMap().size(), 2);
        assertEquals(String.valueOf(commonUtil.getDistanceMap().get(8.0f)), "1.2");
        assertEquals(String.valueOf(commonUtil.getDistanceMap().get(2.0f)), "0.8");
        assertEquals(commonUtil.getWaitingMap().size(), 1);
        assertEquals(String.valueOf(commonUtil.getWaitingMap().get(0.0f)), "0.25");
        assertEquals(String.valueOf(commonUtil.getBasicPrice()), "6.0");
    }

    @Test
    public void splitInput_test(){
        commonUtil = new CommonUtil();
        String input = "1公里,等待0分钟\\n";
        assertEquals(commonUtil.splitInput(input)[0], "1");
        assertEquals(commonUtil.splitInput(input)[1], "0");
        input = "2公里,等待3分钟";
        assertEquals(commonUtil.splitInput(input)[0], "2");
        assertEquals(commonUtil.splitInput(input)[1], "3");
    }

    @Test
    public void getBasicPrice_test(){
        commonUtil = new CommonUtil();
        assertEquals(String.valueOf(commonUtil.getBasicPrice()), String.valueOf(6.0));
    }

    @Test
    public void getDistanceMap_test(){
        commonUtil = new CommonUtil();
        assertEquals(commonUtil.getDistanceMap().size(), 2);
        assertEquals(String.valueOf(commonUtil.getDistanceMap().get(8.0f)), "1.2");
        assertEquals(String.valueOf(commonUtil.getDistanceMap().get(2.0f)), "0.8");
    }

    @Test
    public void getWaitingMap_test(){
        commonUtil = new CommonUtil();
        assertEquals(commonUtil.getWaitingMap().size(), 1);
        assertEquals(String.valueOf(commonUtil.getWaitingMap().get(0.0f)), "0.25");
        assertEquals(String.valueOf(commonUtil.getBasicPrice()), "6.0");
    }
}