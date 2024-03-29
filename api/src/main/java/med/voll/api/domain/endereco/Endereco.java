package med.voll.api.domain.endereco;

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

    public Endereco(DadosEndereco dados) {
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.numero = dados.numero();

    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.bairro()!=null){
            this.bairro = endereco.bairro();
        }
        if(endereco.cep()!=null){
            this.cep = endereco.cep();
        }
        if(endereco.uf()!=null){
            this.uf = endereco.uf();
        }
        if(endereco.cidade()!=null){
            this.cidade = endereco.cidade();
        }
        if(endereco.logradouro()!=null){
            this.logradouro = endereco.logradouro();
        }
        if(endereco.complemento()!=null){
            this.complemento = endereco.complemento();
        }
        if(endereco.numero()!=null){
            this.numero = endereco.numero();
        }
    }
}
