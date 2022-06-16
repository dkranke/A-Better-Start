package de.hsos.swe.abetterstart.common.boundary.rest;

import de.hsos.swe.abetterstart.common.entity.ImportDTO;

import javax.ws.rs.core.Response;

public interface ListResource<E extends ImportDTO<?>> {

    Response options();

    default Response get() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    default Response post(E e) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    default Response put(E e) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    default Response patch(E e) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    default Response delete() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
