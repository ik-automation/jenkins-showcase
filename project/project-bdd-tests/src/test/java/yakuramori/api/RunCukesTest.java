package yakuramori.api;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber.json" },
        features = { "classpath:features/", "src/test/resources/features/" },
        glue = { "lv.ctco.cukesrest", "yakuramori.api" },
        strict = true
)
public class RunCukesTest {
}
