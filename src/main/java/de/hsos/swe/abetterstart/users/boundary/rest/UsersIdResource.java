package de.hsos.swe.abetterstart.users.boundary.rest;

import de.hsos.swe.abetterstart.common.boundary.rest.InstanceResource;
import de.hsos.swe.abetterstart.users.control.ManageUsers;
import de.hsos.swe.abetterstart.users.entity.UserExportDTO;
import de.hsos.swe.abetterstart.users.entity.UserImportDTO;

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
@Path("/api/v2/users/{id:\\w+}")
@RolesAllowed({"user", "admin"})
public class UsersIdResource implements InstanceResource<String, UserImportDTO> {

    private final ManageUsers manageUsers;

    @Context
    private SecurityContext securityContext;

    @Inject
    public UsersIdResource(ManageUsers manageUsers) {
        this.manageUsers = manageUsers;
    }

    @Override @OPTIONS
    public Response options() {
        return Response.ok().allow("GET", "PUT", "DELETE").build();
    }

    @Override @GET
    public Response get(@PathParam("id") String id) {
        return Response.ok(manageUsers.list()).build();
    }

    @PUT @Transactional
    public Response post(UserImportDTO userImportDTO) {
        Optional<UserExportDTO> user = manageUsers.update(userImportDTO);

        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Override @DELETE @Transactional
    public Response delete(@PathParam("id") String id) {
        if (manageUsers.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
