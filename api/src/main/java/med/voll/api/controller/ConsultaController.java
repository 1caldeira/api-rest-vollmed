package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultas agenda;
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, dados.idMedico(), dados.idPaciente(), dados.data()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@RequestBody @Valid DadosCancelamentoConsulta dados){
        try {
            agenda.cancelarConsulta(dados);
        } catch (ValidacaoException e) {
            throw new ValidationException(e);
        }
        return ResponseEntity.noContent().build();
    }
}
