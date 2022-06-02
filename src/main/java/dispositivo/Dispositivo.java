package dispositivo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Dispositivo {
    public static final String PATTERN = "MM/dd/yyyy";
    public static final String SET_CONSULTA_INVALID = "Error en formato de consulta";
    public static final String SET_FECHA_NACIMIENTO_INVALID = "Error en formato de fecha de nacimiento";
    public static final String CONSULTA_MAYOR_FECHA_DE_NACIMIENTO = "Fecha de consulta es antes de nacimiento";
    LocalDate consulta;
    LocalDate nacimiento;
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern(PATTERN, Locale.ENGLISH);

    public void setConsulta(String consulta) throws DateFormatException {
        try {
            this.consulta  = LocalDate.parse(consulta, sdf);
        }
        catch (DateTimeParseException e){
            throw new DateFormatException(SET_CONSULTA_INVALID);
        }
    }

    public void setFechaNacimiento(String nacimiento) throws DateFormatException {
        try {
            this.nacimiento  = LocalDate.parse(nacimiento, sdf);
        }
        catch (DateTimeParseException e){
            throw new DateFormatException(SET_FECHA_NACIMIENTO_INVALID);
        }
    }

    public boolean esMayorDeEdad() throws DateException {
        if (consulta.isBefore(nacimiento)) {
            throw new DateException(CONSULTA_MAYOR_FECHA_DE_NACIMIENTO);
        }
        Period interval = Period.between(nacimiento, consulta);
        return (interval.getYears() >= 18);
    }
}
