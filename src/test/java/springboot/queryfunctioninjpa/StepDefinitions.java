package springboot.queryfunctioninjpa;

import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import springboot.queryfunctioninjpa.model.Employee;

import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
//@SpringBootTest(classes = TestConfig.class)
public class StepDefinitions {

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();

   /* @Given("I can create a new Employee")
    public void i_can_create_a_new_employee() {
        String url = "http://localhost:8080/employee";
        List<Employee>

    }*/


}
