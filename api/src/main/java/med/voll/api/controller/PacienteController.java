package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping("")
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }
    @GetMapping("")
    public ResponseEntity<Page<PacienteDTO>> listar (Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(PacienteDTO::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        if(paciente.isAtivo()){
            return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity reativar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.reativar();
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizarCadastro(@RequestBody DadosAtualizacaoPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarCadastro(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
