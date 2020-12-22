package ru.stqa.bugify.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import ru.stqa.bugify.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTest extends TestBase {

    @Test
    public void testCreateIssue() throws IOException {
        skipIfNotFixed(305);
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("Test").withDescription("Test Description");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }


    private Set<Issue> getIssues() throws IOException {
        String json = RestAssured.get("https://bugify.stqa.ru/api/issues.json").asString();
        JsonElement issues = JsonParser.parseString(json).getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
        }.getType());
    }



    private int createIssue(Issue newIssue) throws IOException {
        String json = RestAssured.given().param("subject", newIssue.getSubject())
                .param("description", newIssue.getDescription()).
                        post("https://bugify.stqa.ru/api/issues.json").asString();
        int issues = JsonParser.parseString(json).getAsJsonObject().get("issue_id").getAsInt();
        return issues;
    }
}
