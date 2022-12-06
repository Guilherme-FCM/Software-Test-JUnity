package br.edu.ifto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estudante {
  private String nome;
  private String matricula;
  private LocalDate dataNascimento;
  private String endereco;
  private String emailInstitucional;
  private List<Celular> celulares = new ArrayList<Celular>();

  public Estudante(String nome, String matricula, LocalDate dataNascimento, String endereco,
      String emailInstitucional) {
    this.nome = nome;
    this.matricula = matricula;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.emailInstitucional = emailInstitucional;
  }

  public String gerarMatricula() {
    return "" + LocalDate.now().getYear() + (new Random().nextInt() * 5);
  }

  public void addCelular(Celular celular) {
    celulares.add(celular);
  }

  public boolean isValid() {
    return this.nome != null &&
        !this.nome.isBlank() &&
        this.matricula != null &&
        !this.matricula.isBlank() &&
        this.dataNascimento != null &&
        this.endereco != null &&
        !this.endereco.isBlank() &&
        this.emailInstitucional != null &&
        !this.emailInstitucional.isBlank();
  }

  public long getCompletedAge() {
    return ChronoUnit.YEARS.between(this.dataNascimento, LocalDate.now());
  }
}
