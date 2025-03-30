package tmobile.utils;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class DriverManager {
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;
        logger.info("Open Web Browser");
    }

    public static void closeBrowserOnFailure(Throwable throwable) {
        logger.error("An error is occured in test: {}", throwable.getMessage());
        closeWebDriver();
    }

    public static void closeBrowser() {
        logger.info("Close browser.");
        closeWebDriver();
    }
}
