package com.jiker.keju;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TaxiReceiptTest {
    private TaxiReceipt taxiReceipt;

    @Test
    public void setReceipt_test() {
        taxiReceipt = new TaxiReceipt();
        float totalPrice = 1.4f;
        taxiReceipt.setReceipt(totalPrice);
        assertEquals(taxiReceipt.getReceipt(), "收费1元\n");

        taxiReceipt = new TaxiReceipt();
        totalPrice = 1.5f;
        taxiReceipt.setReceipt(totalPrice);
        assertEquals(taxiReceipt.getReceipt(), "收费2元\n");
    }

    @Test
    public void caculateTotalPrice_test() {
        taxiReceipt = new TaxiReceipt();
        assertEquals(String.valueOf(taxiReceipt.caculateTotalPrice()), String.valueOf(6.0));
    }

    @Test
    public void getReceipt_test() {
        taxiReceipt = new TaxiReceipt();
        float totalPrice = 1.5f;
        taxiReceipt.setReceipt(totalPrice);
        assertEquals(taxiReceipt.getReceipt(), "收费2元\n");
    }

    @Test
    public void run_test() {
        taxiReceipt = new TaxiReceipt();
        String fileName = "testData.txt";
        try {
            taxiReceipt.run(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(taxiReceipt.getReceipt());
    }

    @Test
    public void doProcess_test(){
        taxiReceipt = new TaxiReceipt();
        String inputLine = "1公里,等待0分钟\n";
        taxiReceipt.doProcess(inputLine);
        assertNotNull(taxiReceipt.getReceipt());
    }

    @Test
    public void file_not_found_test(){
        taxiReceipt = new TaxiReceipt();
        String fileName = "testData111.txt";
        Throwable exception = assertThrows(FileNotFoundException.class, () -> {taxiReceipt.run(fileName);});
        assertTrue(exception.getMessage().contains("testData111.txt"));
    }
}