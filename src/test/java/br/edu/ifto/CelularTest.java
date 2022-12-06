package br.edu.ifto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CelularTest {
    @Test
    @DisplayName("Valida se dados do celular são válidos")
    public void shouldValidEstudante() {
        Celular celular = new Celular("63 99999-9999");
        assertTrue( celular.isValid() );
    }

    @Test
    @DisplayName("Valida se dados do celular não são válidos")
    public void shouldNotValidEstudante() {
        Celular celular = new Celular(" ");
        assertFalse( celular.isValid() );
    }
}
