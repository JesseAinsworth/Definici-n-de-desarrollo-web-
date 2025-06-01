package edu.utvt.examples;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utils {


    public static String calculateAge(String fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar vacía.");
        }

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(fechaNacimiento, fmt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use dd/MM/yyyy.", e);
        }

        LocalDate currentDate = LocalDate.now();
        if (birthDate.isAfter(currentDate)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }

        Period periodo = Period.between(birthDate, currentDate);
        return String.format("Tienes %d años, %d meses y %d días de edad.",
            periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }

}