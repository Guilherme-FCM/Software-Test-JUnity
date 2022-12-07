package br.edu.ifto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TurmaCursoTest {
    private TurmaCurso getValidTurma() {
        return new TurmaCurso("IFTO", 40, LocalDate.parse("2023-02-01"), LocalDate.parse("2023-12-01"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-31"));
    }

    private TurmaCurso getInvalidTurma() {
        return new TurmaCurso("IFTO", 40, LocalDate.parse("2022-02-01"), LocalDate.parse("2022-12-31"), LocalDate.parse("2022-03-01"), LocalDate.parse("2022-04-30"));
    }

    private EstudantesMatriculados getValidEstudanteMatriculado() {
        return new EstudantesMatriculados(
                new Estudante("Guilherme", "2022010", LocalDate.parse("2003-05-13"), "210 sul", "guilherme.milhomem2@estudante.ifto.edu.br"),
                getValidTurma(),
                LocalDate.parse("2022-02-01")
        );
    }

    @Test
    @DisplayName("Valida se dados da turma são válidos")
    public void shouldValidTurma() {
        TurmaCurso turmaCurso = getValidTurma();
        assertTrue( turmaCurso.isValid() );
    }

    @Test
    @DisplayName("Valida se dados da turma não são válidos")
    public void shouldNotValidTurma() {
        TurmaCurso turmaCurso = getInvalidTurma();
        assertFalse( turmaCurso.isValid() );
    }

    @Test
    @DisplayName("Valida se adiciona um estudade à turma e diminui vagas disponiveis")
    public void shouldAddEstudante() {
        EstudantesMatriculados estudantesMatriculados = getValidEstudanteMatriculado();
        TurmaCurso turmaCurso = getValidTurma();
        int vagasInicio = turmaCurso.getVagasDisponiveis();

        assertTrue( turmaCurso.addEstudante(estudantesMatriculados) );

        int vagasFinal = turmaCurso.getVagasDisponiveis();
        assertEquals(vagasFinal, vagasInicio - 1);
    }

    @Test
    @DisplayName("valida se não adiciona um estudade à turma")
    public void shouldNotAddEstudante() {
        EstudantesMatriculados estudantesMatriculados = getValidEstudanteMatriculado();
        TurmaCurso turmaCurso = getValidTurma();
        turmaCurso.setVagasDisponiveis(0);

        assertFalse( turmaCurso.addEstudante(estudantesMatriculados) );
    }

    @Test
    @DisplayName("valida se não é possível matricular estudantes na turma")
    public void shouldCanMatriculate() {
        TurmaCurso turmaCurso = getValidTurma();
        assertTrue( turmaCurso.podeMatricular() );
    }

    @Test
    @DisplayName("valida se é possível matricular estudantes na turma")
    public void shouldCannotMatriculate() {
        TurmaCurso turmaCurso = getInvalidTurma();
        assertFalse( turmaCurso.podeMatricular() );

        TurmaCurso turmaCurso2 = new TurmaCurso("IFTO", 40, LocalDate.parse("2022-02-01"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-01"), LocalDate.parse("2023-12-31"));
        assertFalse( turmaCurso2.podeMatricular() );

        TurmaCurso turmaCurso3 = new TurmaCurso("IFTO", 40, LocalDate.parse("2022-02-01"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-01-01"), LocalDate.parse("2022-06-30"));
        assertFalse( turmaCurso3.podeMatricular() );
    }

    @Test
    @DisplayName("valida se não é possível mostrar os alunos matriculados")
    public void shouldNotShow() {
        TurmaCurso turmaCurso = getValidTurma();
        assertThrows(Exception.class, turmaCurso::getEstudantesMatriculados);
    }
}
