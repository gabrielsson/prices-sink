package dev.gabrielsson.prices;

import dev.gabrielsson.prices.model.DatePrice;
import dev.gabrielsson.prices.model.DatePriceEntity;
import dev.gabrielsson.prices.repository.PricesRepository;
import dev.gabrielsson.prices.service.PricesService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.function.Predicate.not;

@Dependent
@CommandLine.Command(name = "scrapePrices", mixinStandardHelpOptions = true, description = "Scrape prices and store by interval")
public class MainApplication implements Runnable {

    @CommandLine.Option(names = {"-w", "--week"}, description = "should scrape weekly prices")
    boolean week;

    @CommandLine.Option(names = {"-m", "--month"}, description = "should scrape monthly prices")
    boolean month;

    @CommandLine.Option(names = {"-h", "--help", "-?", "-help"}, usageHelp = true, description = "Display this help and exit")
    private boolean help;
    @Inject
    @RestClient
    PricesService pricesService;

    @Inject
    PricesRepository repository;

    @Override
    @ActivateRequestContext
    @Transactional
    public void run() {
        Map<String, List<DatePrice>> data = Collections.emptyMap();
        if (week) {
            data = pricesService.week().getData();
        } else if (month) {
            data = pricesService.month().getData();
        }
        data.forEach((region, value) -> {
            var collect = value.stream().map(p ->
                    new DatePriceEntity()
                            .setPrice(p.getPrice())
                            .setRegion(region)
                            .setTimestamp(p.getDate())
            ).filter(entity -> !repository.exists(entity));

            repository.persist(collect);
        });
    }
}
