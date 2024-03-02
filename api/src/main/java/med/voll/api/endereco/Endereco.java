package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco data) {
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.uf = data.uf();
        this.cidade = data.cidade();
        this.logradouro = data.logradouro();
        this.complemento = data.complemento();
        this.numero = data.numero();

    }
}
