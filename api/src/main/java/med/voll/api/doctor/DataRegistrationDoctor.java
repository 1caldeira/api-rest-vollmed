package med.voll.api.doctor;

import med.voll.api.address.DadosEndereco;

public record DataRegistrationDoctor(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
