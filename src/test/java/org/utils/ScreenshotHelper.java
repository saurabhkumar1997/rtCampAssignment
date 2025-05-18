package org.Utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import org.Core.TestContext;

import java.io.IOException;
import java.nio.file.*;
        import java.util.Comparator;
import java.util.stream.Stream;

public class ScreenshotHelper extends TestContext {

    private static final String SCREENSHOT_DIR = "src/test/resources/Screenshots";

    public static void takeSequentialScreenshot() {
        try {
            // Create the folder if it doesn't exist
            Path screenshotFolder = Paths.get(SCREENSHOT_DIR);
            if (!Files.exists(screenshotFolder)) {
                Files.createDirectory(screenshotFolder);
            }

            // Find the next number in sequence
            int nextNumber = getNextScreenshotNumber();

            // Build the screenshot file path
            String fileName = "screenshot" + nextNumber + ".png";
            Path filePath = screenshotFolder.resolve(fileName);

            // Take and save the screenshot
            page.screenshot(new ScreenshotOptions().setPath(filePath));
            System.out.println(" Screenshot saved at: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getNextScreenshotNumber() throws IOException {
        try (Stream<Path> files = Files.list(Paths.get(SCREENSHOT_DIR))) {
            return files
                    .filter(p -> p.getFileName().toString().matches("screenshot\\d+\\.png"))
                    .map(p -> p.getFileName().toString().replaceAll("\\D+", ""))  // extract digits only
                    .mapToInt(s -> s.isEmpty() ? 0 : Integer.parseInt(s))
                    .max()
                    .orElse(0) + 1;
        }
    }
}
