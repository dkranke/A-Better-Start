package de.hsos.swe.abetterstart.common.boundary.rest;

import de.hsos.swe.abetterstart.common.entity.ImportDTO;

import javax.ws.rs.core.Response;

/**
 * Each REST resource that accesses a single entity should extend this class.
 * In this project some HTTP methods are only used here and ignored in the implementations,
 * but normally all HTTP methods should be used even if they only return the default implementation.
 * NOTE: This is completely optional and a preference from Prof Roosmann.
 */
public interface InstanceResource<Id, IDto extends ImportDTO<?>> {

    Response options();

    default Response get(Id id) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
    default Response post(Id id, IDto iDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
    default Response put(Id id, IDto iDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
    default Response patch(Id id, IDto iDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
    default Response delete(Id id) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
