package med.voll.api.domain.paciente;


public record PacienteDTO(
        String nome,
        String email,
        String telefone,
        String cpf) {
    public PacienteDTO(Paciente paciente) {
        this(paciente.getNome(),paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }


}
