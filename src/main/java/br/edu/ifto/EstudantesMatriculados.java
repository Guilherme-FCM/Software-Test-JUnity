package br.edu.ifto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudantesMatriculados {
  private LocalDate dataMatricula;
  private String matricula;

  public EstudantesMatriculados(String matricula, LocalDate dataMatricula) {
    this.matricula = matricula;
    this.dataMatricula = dataMatricula;
  }

  public List<Estudante> getMatriculados() {
    return new ArrayList<>();
  }

  public boolean isValid() {
    return this.matricula != null &&
      !this.matricula.isBlank() &&
      this.dataMatricula != null;
  }
}
