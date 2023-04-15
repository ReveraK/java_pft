package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.User;

public class UserHelper extends HelperBase {
  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void resetPassword(User user){
    wd.get(app.getProperty("web.baseUrl") + "manage_user_edit_page.php" + "?user_id=" + user.getId());
    click(By.cssSelector("input[value=\"Сбросить пароль\"]"));
  }
}
