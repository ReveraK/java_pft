package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.File;
import java.util.List;


public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  protected String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    //MailMessage mailMessage = mailMessages.stream().filter((x) -> x.to.equals(email)).findAny().get();
    MailMessage mailMessage = mailMessages.stream().filter((x) -> x.to.equals(email)).reduce((x, y) -> y).get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
