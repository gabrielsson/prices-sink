package dev.gabrielsson.prices.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "DatePrice")
public class DatePriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String region;
    private ZonedDateTime timestamp;
    Float price;

    public long getId() {
        return id;
    }

    public DatePriceEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public DatePriceEntity setRegion(String region) {
        this.region = region;
        return this;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public DatePriceEntity setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public DatePriceEntity setPrice(Float price) {
        this.price = price;
        return this;
    }
}
