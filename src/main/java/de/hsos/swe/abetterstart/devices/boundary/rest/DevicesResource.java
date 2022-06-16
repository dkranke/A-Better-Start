package de.hsos.swe.abetterstart.devices.boundary.rest;

import de.hsos.swe.abetterstart.common.boundary.rest.ListResource;
import de.hsos.swe.abetterstart.devices.control.ManageDevices;
import de.hsos.swe.abetterstart.devices.entity.DeviceExportDTO;
import de.hsos.swe.abetterstart.devices.entity.DeviceImportDTO;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Optional;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v2/devices")
@RolesAllowed({"user", "admin"})
public class DevicesResource implements ListResource<DeviceImportDTO> {

    private final ManageDevices manageDevices;

    @Context
    private SecurityContext securityContext;

    @Inject
    public DevicesResource(ManageDevices manageDevices) {
        this.manageDevices = manageDevices;
    }

    @Override @OPTIONS
    public Response options() {
        return Response.ok().allow("GET", "POST").build();
    }

    @GET
    public Response get(@QueryParam("type") String type) {
        if (type == null || type.isEmpty()) {
            return Response.ok(manageDevices.list()).build();
        } else {
            return Response.ok(manageDevices.list(type)).build();
        }
    }

    @Override @POST @Transactional
    public Response post(DeviceImportDTO deviceImportDTO) {
        Optional<DeviceExportDTO> device = manageDevices.create(deviceImportDTO);

        if (device.isPresent()) {
            return Response.ok(device.get()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}