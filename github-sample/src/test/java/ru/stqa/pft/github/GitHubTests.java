package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {


    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("bfba38a8b079912c2271f0c0774b3b0366059983");
        RepoCommits commits = github.repos().
                get(new Coordinates.Simple("Eugeniya-d", "java_pft")).commits();
        for (RepoCommit commit: commits.iterate(new ImmutableMap.Builder<String,String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
