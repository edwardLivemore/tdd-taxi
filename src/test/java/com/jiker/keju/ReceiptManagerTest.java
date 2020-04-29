package com.jiker.keju;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.Test;

public class ReceiptManagerTest {
    private ReceiptManager receiptManager;

    @Test
    public void generateReceiptList_test(){
        receiptManager = new ReceiptManager();
        LinkedHashMap<Float, Float> map = new LinkedHashMap<>();
        map.put(8.0f, 1.2f);
        map.put(2.0f, 0.8f);
        String value = "9.0";
        receiptManager.generateReceiptList(map, value);
        assertEquals(receiptManager.getReceiptCountEntityList().size(), 2);
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getWeight()), String.valueOf(1.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getPrice()), String.valueOf(1.2f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getReceipt()), String.valueOf(1.2f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getWeight()), String.valueOf(6.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getPrice()), String.valueOf(0.8f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getReceipt()), String.valueOf(4.8f));
        receiptManager.cleanReceiptList();
        
        value = "5.0";
        receiptManager.generateReceiptList(map, value);
        assertEquals(receiptManager.getReceiptCountEntityList().size(), 2);
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getWeight()), String.valueOf(0.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getPrice()), String.valueOf(1.2f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getReceipt()), String.valueOf(0.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getWeight()), String.valueOf(3.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getPrice()), String.valueOf(0.8f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getReceipt()), String.valueOf(2.4f));
        receiptManager.cleanReceiptList();

        value = "1.0";
        receiptManager.generateReceiptList(map, value);
        assertEquals(receiptManager.getReceiptCountEntityList().size(), 2);
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getWeight()), String.valueOf(0.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getPrice()), String.valueOf(1.2f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(0).getReceipt()), String.valueOf(0.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getWeight()), String.valueOf(0.0f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getPrice()), String.valueOf(0.8f));
        assertEquals(String.valueOf(receiptManager.getReceiptCountEntityList().get(1).getReceipt()), String.valueOf(0.0f));
        receiptManager.cleanReceiptList();
    }

    @Test
    public void cleanReceiptList_test(){
        receiptManager = new ReceiptManager();
        LinkedHashMap<Float, Float> map = new LinkedHashMap<>();
        map.put(8.0f, 1.2f);
        map.put(2.0f, 0.8f);
        String value = "9.0";
        receiptManager.generateReceiptList(map, value);
        assertEquals(receiptManager.getReceiptCountEntityList().size(), 2);
        receiptManager.cleanReceiptList();
        assertEquals(receiptManager.getReceiptCountEntityList().size(), 0);
    }

    @Test
    public void getReceiptCountEntityList_test(){
        receiptManager = new ReceiptManager();
        assertEquals(receiptManager.getReceiptCountEntityList().size(), 0);
    }
}