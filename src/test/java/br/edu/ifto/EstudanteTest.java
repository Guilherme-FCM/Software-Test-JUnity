package br.edu.ifto;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class EstudanteTest {
    private Estudante getValidEstudante() {
      return new Estudante("Guilherme", "2022010", LocalDate.parse("2003-05-13"), "210 sul", "guilherme.milhomem2@estudante.ifto.edu.br");
    }

    @Test
    @DisplayName("Valida se dados do estudante são válidos")
    public void shouldValidEstudante() {
      Estudante estudante = getValidEstudante();
      assertTrue( estudante.isValid() );
    }

    @Test
    @DisplayName("Valida se dados do estudante não são válidos")
    public void shouldNotValidEstudante() {
      Estudante estudante = new Estudante(" ", "2022010", null, "210 sul", " ");
      assertFalse( estudante.isValid() );
    }

    @Test
    @DisplayName("Valida se o estudante possui ao menos 15 anos completos")
    public void shouldValidEstudanteAge() {
      Estudante estudante = getValidEstudante();
      assertTrue(estudante.getCompletedAge() >= 15);
    }
}