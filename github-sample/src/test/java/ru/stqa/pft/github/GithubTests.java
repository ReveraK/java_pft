package ru.stqa.pft.github;

import com.google.common.collect.ImmutableBiMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("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");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("ReveraK", "java_pft")).commits();
    for (RepoCommit repoCommit: commits.iterate(new ImmutableBiMap.Builder<String, String>().build())){
      System.out.println(new RepoCommit.Smart(repoCommit).message());
    }
  }
}
