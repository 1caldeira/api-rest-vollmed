package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping("/register")
    @Transactional
    public void register(@RequestBody @Valid DadosCadastroMedico data){

        repository.save(new Medico(data));
    }
    @GetMapping
    public String ok(){
        return "ok";
    }
}
