package br.com.confidencecambio.javabasico;

import br.com.confidencecambio.javabasico.service.HelloService;
import br.com.confidencecambio.javabasico.service.ImcService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRs {

    private HelloService service;
    private ImcService imcService;

    public HelloWorldRs(final HelloService service, final ImcService imcService) {

        this.service = service;
        this.imcService = imcService;
    }

    @RequestMapping(value = "/ola-mundo", method = RequestMethod.GET)
    public ResponseEntity<String> olaMundo(@RequestParam(value = "nome", required = false) String nome) {
    	var retorno = "Ola " + service.retornaValorValido(nome);
    	return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/imc", method = RequestMethod.GET)
    public ResponseEntity<String> imc(@RequestParam(value = "peso", required = false) Double peso, @RequestParam(value = "altura", required = false) Double altura) {
    	if(peso == null || altura == null) {
    		return new ResponseEntity<>("Para o cáculo do IMC utilizar o seguinte padrão como exemplo: /imc?peso=73.5&altura=1.65", HttpStatus.OK);
    	}else {
    		var imcRetorno = imcService.retornaValorImc(peso, altura);
    		return new ResponseEntity<>(imcRetorno, HttpStatus.OK);
    	}
    }
}
