package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Raca extends EntidadeDominio{
    private String nome;
    private Porte porte;
    private Animal animal;
}
