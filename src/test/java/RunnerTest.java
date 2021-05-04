import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "tests",//пакет, в котором находятся классы с реализацией шагов и «хуков».
            tags = "@test"
    )
    public class RunnerTest {
    }

