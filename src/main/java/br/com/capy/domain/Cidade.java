package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade extends EntidadeDominio{
    private String nome;
    private Estado estado;

}
