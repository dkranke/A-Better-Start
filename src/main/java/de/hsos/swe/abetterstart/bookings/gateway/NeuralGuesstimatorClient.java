package de.hsos.swe.abetterstart.bookings.gateway;

import de.hsos.swe.abetterstart.bookings.entity.BookingImportDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;

@RegisterRestClient(baseUri = "http://localhost:8123/api")
public interface NeuralGuesstimatorClient {

    @GET
    long getExpectedDuration(BookingImportDTO booking);
}
