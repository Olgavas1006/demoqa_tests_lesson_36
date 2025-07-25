package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("form")
    void systemPropertiesTest() {
        String browser = System.getProperty("browser", "firefox");
        String version = System.getProperty("version", "124");
        String windowSize = System.getProperty("windowSize", "1920x1080");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(windowSize);
    }

    @Test
    @Tag("property")
    void systemProperties1Test() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "131");
        String windowSize = System.getProperty("windowSize", "1280x720");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(windowSize);
    }

}
