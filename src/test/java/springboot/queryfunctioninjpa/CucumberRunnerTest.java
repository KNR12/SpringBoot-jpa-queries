package springboot.queryfunctioninjpa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cucumber.feature"
)
public class CucumberRunnerTest {
}
