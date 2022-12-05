package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel extends EntidadeDominio {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Telefone telefone;
}
