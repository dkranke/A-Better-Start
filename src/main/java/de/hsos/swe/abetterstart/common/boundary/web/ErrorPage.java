package de.hsos.swe.abetterstart.common.boundary.web;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

@CheckedTemplate
public class ErrorPage {

    public static native TemplateInstance error(int errorCode, String errorMessage);
}
