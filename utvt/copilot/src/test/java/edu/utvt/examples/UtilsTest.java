package edu.utvt.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




class UtilsTest {

    @Test
    void testCalculateAge_ValidDate() {
        // Given a known birth date
        LocalDate now = LocalDate.now();
        LocalDate birthDate = now.minusYears(25).minusMonths(3).minusDays(10);
        String fechaNacimiento = birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // When
        String result = Utils.calculateAge(fechaNacimiento);

        // Then
        assertTrue(result.contains("Tienes 25 años, 3 meses y 10 días de edad.") ||
                   result.matches("Tienes \\d+ años, \\d+ meses y \\d+ días de edad."));
    }

    @Test
    void testCalculateAge_NullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Utils.calculateAge(null);
        });
        assertEquals("La fecha de nacimiento no puede estar vacía.", exception.getMessage());
    }

    @Test
    void testCalculateAge_EmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Utils.calculateAge("   ");
        });
        assertEquals("La fecha de nacimiento no puede estar vacía.", exception.getMessage());
    }

    @Test
    void testCalculateAge_InvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Utils.calculateAge("2020-01-01");
        });
        assertTrue(exception.getMessage().contains("Formato de fecha inválido"));
    }

    @Test
    void testCalculateAge_FutureDate() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        String fechaNacimiento = futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Utils.calculateAge(fechaNacimiento);
        });
        assertEquals("La fecha de nacimiento no puede ser futura.", exception.getMessage());
    }
}