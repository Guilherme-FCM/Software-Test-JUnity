package br.edu.ifto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurmaCurso {
  private String local;
  private int vagas;
  private int vagasDisponiveis;
  private LocalDate inicioAulas;
  private LocalDate fimAulas;
  private LocalDate inicioMatriculas;
  private LocalDate fimMatriculas;
  public List<EstudantesMatriculados> estudantesMatriculados = new ArrayList<>();

  public TurmaCurso(String local, int vagas, LocalDate inicioAulas, LocalDate fimAulas, LocalDate inicioMatriculas, LocalDate fimMatriculas) {
    this.local = local;
    this.vagas = vagas;
    this.vagasDisponiveis = vagas;
    this.inicioAulas = inicioAulas;
    this.fimAulas = fimAulas;
    this.inicioMatriculas = inicioMatriculas;
    this.fimMatriculas = fimMatriculas;
  }

  public int getVagasDisponiveis() {
    return vagasDisponiveis;
  }

  public void setVagasDisponiveis(int vagasDisponiveis) {
    this.vagasDisponiveis = vagasDisponiveis;
  }

  public LocalDate[] getPeriodoMatriculas() {
    return new LocalDate[] { this.inicioMatriculas, this.fimMatriculas };
  }

  public boolean podeMatricular() {
    LocalDate dataAtual = LocalDate.now();
    LocalDate[] periodoMatriculas = getPeriodoMatriculas();

    boolean dentroPeriodoMatriculas =
          dataAtual.compareTo(periodoMatriculas[0]) >= 0 &&
          dataAtual.compareTo(periodoMatriculas[1]) <= 0;

    return getVagasDisponiveis() > 0 && dentroPeriodoMatriculas;
  }

  public boolean addEstudante(EstudantesMatriculados estudante) {
    if (podeMatricular()) {
      boolean added = estudantesMatriculados.add(estudante);
      if (added) setVagasDisponiveis( getVagasDisponiveis() -1 );
      return true;
    }
    return false;
  }

  public boolean isValid() {
    return
      this.local != null &&
      !this.local.isBlank() &&
      this.vagas > 0 &&
      this.vagasDisponiveis <= this.vagas &&
      this.inicioAulas != null &&
      this.fimAulas != null &&
      this.inicioMatriculas != null &&
      this.fimMatriculas != null &&
      this.inicioAulas.compareTo(this.fimAulas) < 0 &&
      this.inicioMatriculas.compareTo(this.fimMatriculas) < 0 &&
      this.fimMatriculas.compareTo(this.inicioAulas) <= 0;
  }

  public List<EstudantesMatriculados> getEstudantesMatriculados() throws Exception {
    if(estudantesMatriculados.size() == 0)
      throw new Exception("Não há estudantes cadastrados");
    return estudantesMatriculados;
  }
}
