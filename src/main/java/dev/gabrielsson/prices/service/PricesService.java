package dev.gabrielsson.prices.service;

import dev.gabrielsson.prices.model.Prices;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient(configKey="prices-api")
public interface PricesService {

    @GET
    @Path("/week.json")
    Prices week();

    @GET
    @Path("/month.json")
    Prices month();

}
