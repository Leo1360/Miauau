package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefone extends EntidadeDominio{
    private String numero;
    private String ddd;
    private boolean isWhatsappp;

}
