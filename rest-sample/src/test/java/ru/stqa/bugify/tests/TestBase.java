package ru.stqa.bugify.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {
    @BeforeSuite(alwaysRun = true)
    public void init() throws Exception {
        RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
    }


    public String getIssueStatus(int issueId) {
        String json = RestAssured.get("https://bugify.stqa.ru/api/issues/" + issueId + ".json").asString();
        JsonElement issues = JsonParser.parseString(json).getAsJsonObject().get("issues");
        String stateName = issues.getAsJsonArray().iterator().next()
                .getAsJsonObject().get("state_name").getAsString();
        return stateName;

    }

    public boolean isIssueOpen(int issueId) throws RemoteException, MalformedURLException {
        String issueStatus = getIssueStatus(issueId);
        return !issueStatus.equals("Closed");
    }

    public void skipIfNotFixed(int issueId) throws RemoteException, MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
