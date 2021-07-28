package br.com.confidencecambio.javabasico.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImcService {

//    private static final Double valorAltura = 1.65;

    public String retornaValorImc(@Nullable Double peso,  @Nullable Double altura) {
        return "O seu IMC é:  " + Optional.ofNullable(Double.toString(peso/(Math.pow(altura, 2)))).orElse("Para o cáculo do IMC utilizar o seguinte padrão como exemplo: /imc?peso=73.5&altura=1.65");
    }
}
