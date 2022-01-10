package br.com.projeto.cadastrocliente.feature.start;

import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartScenario {


    @Before
    public void beforeall(Scenario scenario) {
        //Start here your scenario
        
    }

    @After
    public void hookToEachAfter(Scenario scenario) {
        //Start here your scenario
    }

}