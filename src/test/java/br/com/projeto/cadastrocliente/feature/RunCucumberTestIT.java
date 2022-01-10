package br.com.projeto.cadastrocliente.feature;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:br/com/projeto/cadastrocliente/feature/"},
        plugin = { "pretty" },
        extraGlue = {"br.com.projeto.cadastrocliente.feature.start"}
        )
public class RunCucumberTestIT {

}
