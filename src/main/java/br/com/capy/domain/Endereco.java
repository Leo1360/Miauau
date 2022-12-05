package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends EntidadeDominio{
    private String logradouro;
    private String bairro;
    private String cep;
    private String complemento;
    private String numero;
    private Cidade cidade;


}
