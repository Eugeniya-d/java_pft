package ru.mantis.pft.appmanager;

import org.openqa.selenium.By;
import ru.mantis.pft.models.UserData;

public class ChangePasswordHelper extends HelperBase {
    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void login(UserData user) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), user.getUsername());
        click(By.cssSelector("input[value='Войти']"));
        type(By.name("password"), user.getPassword());
        click(By.cssSelector("input[value='Войти']"));

    }
}
