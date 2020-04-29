package com.jiker.keju;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReceiptManager {
    private List<ReceiptCountEntity> receiptCountEntityList = new ArrayList<>();

    public void generateReceiptList(LinkedHashMap<Float, Float> map, String input) {
        float value = Float.parseFloat(input);
        Iterator<Map.Entry<Float, Float>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Float, Float> entry = iterator.next();
            float weight = Math.max(value - entry.getKey(), 0.0f);
            receiptCountEntityList.add(new ReceiptCountEntity(weight, entry.getValue()));
            value = value - weight;
        }
    }

    public void cleanReceiptList() {
        receiptCountEntityList.clear();
    }

	public List<ReceiptCountEntity> getReceiptCountEntityList() {
		return this.receiptCountEntityList;
	}
}