package br.edu.ifto;

import java.time.LocalDate;

public class EstudantesMatriculados {
  private LocalDate dataMatricula;
  private Estudante estudante;
  private TurmaCurso turmaCurso;

  public EstudantesMatriculados(Estudante estudante, TurmaCurso turmaCurso, LocalDate dataMatricula) {
    this.estudante = estudante;
    this.turmaCurso = turmaCurso;
    this.dataMatricula = dataMatricula;
  }

  public boolean isValid() {
    return this.estudante != null &&
      this.turmaCurso != null &&
      this.dataMatricula != null;
  }
}
