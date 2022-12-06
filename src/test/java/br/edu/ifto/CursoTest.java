package br.edu.ifto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CursoTest {
    @Test
    @DisplayName("Valida se dados do curso são válidos")
    public void shouldValidCurso() {
        Curso curso = new Curso("Sistemas para Internet", "500 horas", "Curso do IFTO");
        assertTrue( curso.isValid() );
    }

    @Test
    @DisplayName("Valida se dados do curso não são válidos")
    public void shouldNotValidCurso() {
        Curso curso = new Curso("Sistemas para Internet", " ", null);
        assertFalse( curso.isValid() );
    }
}
