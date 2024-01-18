package io.github.agebhar1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class GitCommitTest {

    private static final Properties properties = new Properties();

    static {
//        try {
//            var resource = GitCommitTest.class.getResource("/git.properties");
//            if (resource != null) {
//                try (var stream = resource.openStream()) {
//                    properties.load(stream);
//                }
//            }
//        } catch (IOException ignore) {
//        }
    }

    @Test
    public void testGitCommitIdDescribe() {
        properties.forEach((key, value) -> System.out.printf(">> %s=%s%n", key, value));

        var gitCommitIdDescribe = properties.getOrDefault("git.commit.id.describe", "unknown-git-rev").toString();
        assertThat(gitCommitIdDescribe).matches("[0-9a-f]+(-dirty)?");
    }

}
