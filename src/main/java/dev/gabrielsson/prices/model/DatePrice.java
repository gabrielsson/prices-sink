package dev.gabrielsson.prices.model;

import java.time.ZonedDateTime;

public class DatePrice {
    public ZonedDateTime getDate() {
        return date;
    }

    public DatePrice setDate(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public DatePrice setPrice(Float price) {
        this.price = price;
        return this;
    }

    private ZonedDateTime date;
    private Float price;
}
