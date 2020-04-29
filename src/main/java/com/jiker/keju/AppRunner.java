package com.jiker.keju;

public class AppRunner {

    public static void main(String[] args) throws Exception {
        TaxiReceipt taxiReceipt = new TaxiReceipt();
        String testDataFile = args[0];
        taxiReceipt.run(testDataFile);
        String receipt = taxiReceipt.getReceipt();
        System.out.println(receipt);
    }
}
