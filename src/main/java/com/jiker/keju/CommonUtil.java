package com.jiker.keju;

import java.util.LinkedHashMap;

public class CommonUtil {
    private LinkedHashMap<Float, Float> distanceMap;
    private LinkedHashMap<Float, Float> waitingMap;
    private String[] filterString;
    private float basicPrice;

    public CommonUtil() {
        this.distanceMap = new LinkedHashMap<>();
        this.distanceMap.put(8.0f, 1.2f);
        this.distanceMap.put(2.0f, 0.8f);
        this.waitingMap = new LinkedHashMap<>();
        this.waitingMap.put(0.0f, 0.25f);
        this.filterString = new String[] { "公里", "等待", "分钟", "\\n" };
        this.basicPrice = 6.0f;
    }

    public String[] splitInput(String inputLine) {
        for (String filterString : this.filterString) {
            inputLine = inputLine.replace(filterString, "");
        }
        return inputLine.split(",");
    }

	public float getBasicPrice() {
		return this.basicPrice;
    }

	public LinkedHashMap<Float, Float> getDistanceMap() {
		return this.distanceMap;
	}

	public LinkedHashMap<Float, Float> getWaitingMap() {
		return this.waitingMap;
	}
}