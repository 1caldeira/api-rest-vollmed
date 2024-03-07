package med.voll.api.medico;

public record MedicoDTO(Long Id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
