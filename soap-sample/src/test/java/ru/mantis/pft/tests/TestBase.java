package ru.mantis.pft.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.mantis.pft.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected static ApplicationManager app;

    static {
        try {
            app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
       // app.ftp().upload(new File("src/test/resources/config_inc.php")
                //,"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        //app.ftp().restore("config_inc.php.bak","config_inc.php");
        app.stop();

    }
}