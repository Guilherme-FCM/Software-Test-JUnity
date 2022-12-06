package br.edu.ifto;

public class Celular {
  private String numero;
  
  public Celular(String numero) {
    this.numero = numero;
  }

  public boolean isValid() {
    return this.numero != null && !this.numero.isBlank();
  }
}
