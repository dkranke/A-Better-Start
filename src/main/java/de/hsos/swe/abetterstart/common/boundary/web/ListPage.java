package de.hsos.swe.abetterstart.common.boundary.web;

import de.hsos.swe.abetterstart.common.entity.ImportDTO;
import io.quarkus.qute.TemplateInstance;

public interface ListPage<IDto extends ImportDTO<?>> {

    default TemplateInstance get() {
        return null;
    }

    default TemplateInstance post(IDto iDto) {
        return null;
    }
}
