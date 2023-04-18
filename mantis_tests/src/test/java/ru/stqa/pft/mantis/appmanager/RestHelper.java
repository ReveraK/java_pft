package ru.stqa.pft.mantis.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import ru.stqa.pft.mantis.model.IssueBugify;

import java.io.IOException;
import java.util.Set;

import static org.apache.http.client.fluent.Request.Get;

public class RestHelper {

  private ApplicationManager app;

  public RestHelper(ApplicationManager app) {
    this.app = app;
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    String json = getExecutor().execute(Get("https://bugify.stqa.ru/api/issues/" + issueId + ".json")).returnContent().toString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    Set<IssueBugify> IssueBugifys = new Gson().fromJson(issues, new TypeToken<Set<IssueBugify>>(){}.getType());
    IssueBugify issue = IssueBugifys.iterator().next();
    return !(issue.getState().equals("Resolved") || issue.getState().equals("Closed"));
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("b31e382ca8445202e66b03aaf31508a3", "");
  }
}
