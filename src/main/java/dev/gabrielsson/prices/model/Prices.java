package dev.gabrielsson.prices.model;

import java.util.List;
import java.util.Map;

public class Prices {

    //map of region to list of hourly prices
    public Map<String, List<DatePrice>> getData() {
        return data;
    }

    public Prices setData(Map<String, List<DatePrice>> data) {
        this.data = data;
        return this;
    }

    private Map<String, List<DatePrice>> data;
}
