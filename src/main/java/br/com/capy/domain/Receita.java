package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receita extends EntidadeDominio{
    private Date data;
    private List<ItemReceita> itemReceitaList;
}
