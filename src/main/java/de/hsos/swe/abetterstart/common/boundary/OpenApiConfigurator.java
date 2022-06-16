package de.hsos.swe.abetterstart.common.boundary;

import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;

import java.util.List;

public class OpenApiConfigurator implements OASFilter {

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        List<String> paths = openAPI.getPaths().getPathItems().keySet().stream()
                .filter(path -> !path.startsWith("/api/"))
                .toList();
        paths.forEach(openAPI.getPaths()::removePathItem);

        List<String> schemas = openAPI.getComponents().getSchemas().keySet().stream()
                .filter(schema -> !schema.endsWith("DTO"))
                .toList();
        schemas.forEach(openAPI.getComponents()::removeSchema);
    }
}
