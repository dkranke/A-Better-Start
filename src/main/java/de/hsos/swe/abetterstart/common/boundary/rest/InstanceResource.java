package de.hsos.swe.abetterstart.common.boundary.rest;

import de.hsos.swe.abetterstart.common.entity.ImportDTO;

import javax.ws.rs.core.Response;

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
