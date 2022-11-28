package dev.gabrielsson.prices.repository;

import dev.gabrielsson.prices.model.DatePriceEntity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PricesRepository implements PanacheRepository<DatePriceEntity> {
    public boolean exists(DatePriceEntity entity) {
        var params = Parameters
                .with("region", entity.getRegion())
                .and("timestamp", entity.getTimestamp());
        PanacheQuery<DatePriceEntity> query = find("region = :region and timestamp = :timestamp", params);
        return query.count() > 0;
    }
}