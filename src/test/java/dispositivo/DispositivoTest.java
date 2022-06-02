package dispositivo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DispositivoTest {
    String fechaNacimiento;
    String fechaConsultaInv;
    String fechaConsultaPos;
    String fechaConsultaNeg;
    String fechaInv;
    Dispositivo dispositivo;

    @BeforeEach
    public void setUp(){
        fechaNacimiento ="06/24/2000";
        fechaConsultaPos ="06/25/2018";
        fechaConsultaNeg ="06/23/2018";
        fechaConsultaInv ="06/23/2000";
        fechaInv ="06232000";
        dispositivo = new Dispositivo();
    }


    @Test()
    @DisplayName("Consulta")
    void testSetConsulta() {
        DateFormatException ex = assertThrows(DateFormatException.class, ()->dispositivo.setConsulta(fechaInv));
        assertSame(Dispositivo.SET_CONSULTA_INVALID, ex.getMessage());
        assertAll( ()-> dispositivo.setConsulta(fechaConsultaPos));
    }

    @Test
    @DisplayName("Fecha de Nacimiento")
    void testSetFechaNacimiento() {
        DateFormatException ex = assertThrows(DateFormatException.class, ()->dispositivo.setFechaNacimiento(fechaInv));
        assertSame(Dispositivo.SET_FECHA_NACIMIENTO_INVALID, ex.getMessage());
        assertAll( ()-> dispositivo.setFechaNacimiento(fechaNacimiento));
    }


    @Test
    @DisplayName("Es Mayor de Edad")
    void testEsMayorDeEdad() throws DateFormatException, DateException {
        dispositivo.setConsulta(fechaConsultaPos);
        dispositivo.setFechaNacimiento(fechaNacimiento);
        assertAll( ()-> dispositivo.esMayorDeEdad());
        assertTrue(dispositivo.esMayorDeEdad());
        dispositivo.setConsulta(fechaConsultaNeg);
        assertAll( ()-> dispositivo.esMayorDeEdad());
        assertFalse(dispositivo.esMayorDeEdad());
        dispositivo.setConsulta(fechaConsultaInv);
        DateException ex = assertThrows(DateException.class, ()->dispositivo.esMayorDeEdad());
        assertSame(Dispositivo.CONSULTA_MAYOR_FECHA_DE_NACIMIENTO, ex.getMessage());
    }
}