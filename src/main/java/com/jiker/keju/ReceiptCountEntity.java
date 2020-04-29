package com.jiker.keju;

public class ReceiptCountEntity {
    private float weight; // 系数
    private float price; // 单价

    public ReceiptCountEntity(float weight, float price) {
        this.weight = weight;
        this.price = price;
    }

    public float getReceipt() {
        return this.weight * this.price;
    }

    public float getWeight(){
        return this.weight;
    }

    public float getPrice(){
        return this.price;
    }
}
