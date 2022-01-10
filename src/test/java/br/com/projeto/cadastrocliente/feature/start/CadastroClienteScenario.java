package br.com.projeto.cadastrocliente.feature.start;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projeto.cadastrocliente.feature.AbstractSteps;
import br.com.projeto.cadastrocliente.feature.CidadeScenarioFactory;
import br.com.projeto.cadastrocliente.repository.CidadeRepository;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CadastroClienteScenario extends AbstractSteps {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    @Before
    public void beforeall(Scenario scenario) {
        if (testContext().get(scenario.getId()) == null) {
            testContext().set(scenario.getId(), true);

            try {
                log.info("Init - beforeEverthing");

                cidadeRepository.save(CidadeScenarioFactory.CIDADE_BDD);
                log.info("End - beforeEverthing");

            } catch (Exception e) {
                log.error("error={}", e.getCause());
            }
        }

    }

    @After
    public void hookToEachAfter(Scenario scenario) {
        try {
            log.info("Init - afterEverthing");
            cidadeRepository.delete(CidadeScenarioFactory.CIDADE_BDD);
        } catch (Exception e) {
            log.error("error={}", e.getCause());
        }
    }
}
