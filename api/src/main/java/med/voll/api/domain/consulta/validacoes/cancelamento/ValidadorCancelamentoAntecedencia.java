package med.voll.api.domain.consulta.validacoes.cancelamento;


import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorCancelamentoAntecedencia implements ValidadorCancelamentoDeConsulta{

    public void validar(DadosCancelamentoConsulta dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, dataConsulta).toHours();

        if(diferencaEmHoras < 24){
            throw new ValidacaoException("Cancelamento deve ser efetuado com antecedência mínima de 24 horas.");
        }
    }
}
