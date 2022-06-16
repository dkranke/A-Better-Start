package de.hsos.swe.abetterstart.common.boundary.web;

import de.hsos.swe.abetterstart.common.entity.ImportDTO;
import io.quarkus.qute.TemplateInstance;

public interface InstancePage<Id, IDto extends ImportDTO<?>> {

    default TemplateInstance get(Id id) {
        return null;
    }

    default TemplateInstance post(Id id, IDto iDto) {
        return null;
    }
}
