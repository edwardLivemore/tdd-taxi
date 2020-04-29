package com.jiker.keju;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReceiptCountEntityTest {
    private ReceiptCountEntity receiptCountEntity;
    @Test
    public void construct_test(){
        float weight = 1.0f;
        float price = 2.0f;
        receiptCountEntity = new ReceiptCountEntity(weight, price);
        assertEquals(String.valueOf(receiptCountEntity.getWeight()), String.valueOf(weight));
        assertEquals(String.valueOf(receiptCountEntity.getPrice()), String.valueOf(price));
    }

    @Test
    public void getReceipt_test(){
        receiptCountEntity = new ReceiptCountEntity(2.0f, 3.0f);
        assertEquals(String.valueOf(receiptCountEntity.getReceipt()), String.valueOf(6.0));
    }

    @Test
    public void getWeight_test(){
        float weight = 1.0f;
        float price = 2.0f;
        receiptCountEntity = new ReceiptCountEntity(weight, price);
        assertEquals(String.valueOf(receiptCountEntity.getWeight()), String.valueOf(weight));
    }

    @Test
    public void getPrice_test(){
        float weight = 1.0f;
        float price = 2.0f;
        receiptCountEntity = new ReceiptCountEntity(weight, price);
        assertEquals(String.valueOf(receiptCountEntity.getPrice()), String.valueOf(price));
    }
}