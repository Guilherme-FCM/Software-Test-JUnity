package br.edu.ifto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstudantesMatriculadosTest {
    @Test
    @DisplayName("Valida se dados do estudantes matriculados são válidos")
    public void shouldValidEstudante() {
        EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados( "2022010", LocalDate.parse("2022-02-01"));
        assertTrue( estudantesMatriculados.isValid() );
    }

    @Test
    @DisplayName("Valida se dados do estudantes matriculados não são válidos")
    public void shouldNotValidEstudante() {
        EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados( "", LocalDate.parse("2022-02-01"));
        assertFalse( estudantesMatriculados.isValid() );
    }
}
