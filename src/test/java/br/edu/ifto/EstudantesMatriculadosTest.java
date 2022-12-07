package br.edu.ifto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstudantesMatriculadosTest {
    private Estudante getEstudanteInstance() {
        return new Estudante("Guilherme", "2022010", LocalDate.parse("2003-05-13"), "210 sul", "guilherme.milhomem2@estudante.ifto.edu.br");
    }

    private TurmaCurso getTurmaInstance() {
        return new TurmaCurso("IFTO", 40, LocalDate.parse("2022-02-01"), LocalDate.parse("2022-12-31"), LocalDate.parse("2022-03-01"), LocalDate.parse("2022-04-30"));
    }
    @Test
    @DisplayName("Valida se dados do estudantes matriculados são válidos")
    public void shouldValidEstudante() {
        EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(
                getEstudanteInstance(),
                getTurmaInstance(),
                LocalDate.parse("2022-02-01")
        );
        assertTrue( estudantesMatriculados.isValid() );
    }

    @Test
    @DisplayName("Valida se dados do estudantes matriculados não são válidos")
    public void shouldNotValidEstudante() {
        EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados( null, null, LocalDate.parse("2022-02-01"));
        assertFalse( estudantesMatriculados.isValid() );
    }
}
