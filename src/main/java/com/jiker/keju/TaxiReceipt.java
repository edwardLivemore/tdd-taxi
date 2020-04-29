package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TaxiReceipt {
    private String receipt = "";
    private CommonUtil commonUtil = new CommonUtil();
    private ReceiptManager receiptManager = new ReceiptManager();

    public void run(String fileName) throws Exception {
        fileName = "src/main/resources/" + fileName;
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String inputLine;
        while (null != (inputLine = br.readLine())) {
            doProcess(inputLine);
        }
        br.close();
    }

    public void doProcess(String inputLine) {
        String[] input = commonUtil.splitInput(inputLine);
        receiptManager.generateReceiptList(commonUtil.getDistanceMap(), input[0]);
        receiptManager.generateReceiptList(commonUtil.getWaitingMap(), input[1]);
        setReceipt(caculateTotalPrice());
        receiptManager.cleanReceiptList();
    }

    public void setReceipt(float totalPrice) {
        receipt = receipt + "收费" + Math.round(totalPrice) + "元\n";
    }

    public float caculateTotalPrice() {
        float totalPrice = commonUtil.getBasicPrice();
        for (ReceiptCountEntity entity : receiptManager.getReceiptCountEntityList()) {
            totalPrice = totalPrice + entity.getReceipt();
        }
        return totalPrice;
    }

    public String getReceipt() {
        return this.receipt;
    }
}