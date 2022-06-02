package dispositivo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Dispositivo {
    public static final String DATE_EXCEPTION = "DATE_EXCEPTION";
    public static final String DATE_FORMAT_EXCEPTION = "DATE_FORMAT_EXCEPTION";
    public static final String PATTERN = "MM/dd/yyyy";
    LocalDate consulta;
    LocalDate nacimiento;
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern(PATTERN, Locale.ENGLISH);

    public void setConsulta(String consulta) throws DateFormatException {
        try {
            this.consulta  = LocalDate.parse(consulta, sdf);
        }
        catch (DateTimeParseException e){
            throw new DateFormatException(DATE_FORMAT_EXCEPTION,"Error en formato de consulta");
        }
    }

    public void setFechaNacimiento(String nacimiento) throws DateFormatException {
        try {
            this.nacimiento  = LocalDate.parse(nacimiento, sdf);
        }
        catch (DateTimeParseException e){
            throw new DateFormatException(DATE_FORMAT_EXCEPTION,"Error en formato de consulta");
        }
    }

    public boolean esMayorDeEdad() throws DateException {
        if (consulta.isBefore(nacimiento)) {
            throw new DateException(DATE_EXCEPTION,"Fecha de consulta es antes de nacimiento");
        }
        Period interval = Period.between(nacimiento, consulta);
        return (interval.getYears() >= 18);
    }
}
