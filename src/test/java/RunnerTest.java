import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/resources/features",
            glue = "step",//пакет, в котором находятся классы с реализацией шагов и «хуков».
            tags = "@test"
    )
    public class RunnerTest {
    }

