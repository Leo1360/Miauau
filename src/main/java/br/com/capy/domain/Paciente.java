package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends EntidadeDominio{
    private String nome;
    private int idade;
    private String pedigrie;
    private float peso;
    private boolean ativo;
    private Responsavel responsavel;
    private List<Exame> exameList = new ArrayList<>();
    private List<Consulta> consultaList = new ArrayList<>();
    private List<Adoecimento> adoecimentoList = new ArrayList<>();
    private List<Receita> receitaList = new ArrayList<>();
    private Raca raca;

    public Paciente(String nome, int idade, String pedigrie, float peso, boolean ativo, Responsavel responsavel, Raca raca) {
        this.nome = nome;
        this.idade = idade;
        this.pedigrie = pedigrie;
        this.peso = peso;
        this.ativo = ativo;
        this.responsavel = responsavel;
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pedigrie='" + pedigrie + '\'' +
                ", peso=" + peso +
                ", ativo=" + ativo +
                ", responsavel=" + responsavel +
                ", exameList=" + exameList +
                ", consultaList=" + consultaList +
                ", adoecimentoList=" + adoecimentoList +
                ", receitaList=" + receitaList +
                ", raca=" + raca +
                ", id=" + id +
                '}';
    }
}
