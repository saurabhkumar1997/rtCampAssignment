package org.Core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.Utils.WebUtil;


public class Hooks extends WebUtil {
    @Before
    public void beforeLogin  (Scenario scenario1) {
        scenario = scenario1;
String featureDescription = scenario.getUri().toString();
fileName = extractFileName(featureDescription);
scenarioName = scenario.getName();
        webInit();

    }
    @After
    public void closeBrowser(){
        webTearDown();

    }
    public static String extractFileName(String filePath) {

        // Extract the file name from the file path

        int lastSlashIndex = filePath.lastIndexOf('/');

        int lastBackslashIndex = filePath.lastIndexOf('\\');

        int startIndex = Math.max(lastSlashIndex, lastBackslashIndex);

        if (startIndex != -1 && startIndex < filePath.length() - 1) {

            String fileNameWithExtension = filePath.substring(startIndex + 1);

            int dotIndex = fileNameWithExtension.lastIndexOf('.');

            if (dotIndex != -1) {

                return fileNameWithExtension.substring(0, dotIndex);

            } else {

                return fileNameWithExtension; // No extension found

            }

        }

        return ""; // Invalid file path

    }

}
