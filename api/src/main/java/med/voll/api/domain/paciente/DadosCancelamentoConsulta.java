package med.voll.api.domain.paciente;

import java.time.LocalDateTime;

public record DadosCancelamentoConsulta(
        Long id,
        String motivoCancelamento,
        LocalDateTime data
) {
}
