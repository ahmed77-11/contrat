package com.medfactor.contrat.utils;

import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PathUtil {

    /**
     * Splits the full PDF file path into a base path (up to "static" folder)
     * and a relative path (from after "static" to the end).
     *
     * @param fullPath the complete PDF file path.
     */
    public static String splitPdfFilePath(String fullPath) throws NotFoundException {
        // Normalize path: replace all backslashes with forward slashes
        fullPath = fullPath.replaceAll("\\\\", "/");

        // Define the marker as "static/" using forward slashes
        String marker = "static/";
        int markerIndex = fullPath.indexOf(marker);

        if (markerIndex != -1) {
            // Base path: from the start-up to and including "static/"
            String basePath = fullPath.substring(0, markerIndex + marker.length());
            // Relative path: everything after "static/"
            String relativePath = fullPath.substring(markerIndex + marker.length());
            // Replace any multiple forward slashes with a single slash
            relativePath = relativePath.replaceAll("//+", "/");
            // Prepend your desired URL path
            relativePath = "/factoring/contrat/" + relativePath;

            return relativePath;
        } else {
            throw new NotFoundException("there is an error in creation of the relative path");
        }
    }

}