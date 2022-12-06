package br.edu.ifto;

import java.util.ArrayList;
import java.util.List;

public class Curso {
  private String nome;
  private String cargaHoraria;
  private String descricao;
  private List<TurmaCurso> turmas = new ArrayList<>();

  public Curso(String nome, String cargaHoraria, String descricao) {
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.descricao = descricao;
  }

  public boolean isValid() {
    return this.nome != null &&
      !this.nome.isBlank() &&
      this.cargaHoraria != null &&
      !this.cargaHoraria.isBlank() &&
      this.descricao != null &&
      !this.descricao.isBlank();
  }
}
