import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestTemperatureConverter {
    TemperatureConverter converter;

    @Before
    public void initialize() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testTemperatureConverter() {
        assertEquals(-4.0, converter.convertCtoF(-20), 0.0001);
        assertEquals(32.0, converter.convertCtoF(0), 0.0001);
        assertEquals(68.0, converter.convertCtoF(20), 0.0001);

        assertEquals(-45.55555, converter.convertFtoC(-50), 0.0001);
        assertEquals(-17.77777, converter.convertFtoC(0), 0.0001);
        assertEquals(10.0, converter.convertFtoC(50), 0.0001);

        assertEquals(-573.2, converter.convertKtoC(-300), 0.0001);
        assertEquals(-273.2, converter.convertKtoC(0), 0.0001);
        assertEquals(26.8, converter.convertKtoC(300), 0.0001);

        assertEquals(-226.8, converter.convertCtoK(-500), 0.0001);
        assertEquals(273.2, converter.convertCtoK(0), 0.0001);
        assertEquals(773.2, converter.convertCtoK(500), 0.0001);


        assertEquals(-22.38888, converter.convertFtoK(-500), 0.0001);
        assertEquals(255.38888, converter.convertFtoK(0), 0.0001);
        assertEquals(533.16666, converter.convertFtoK(500), 0.0001);

        assertEquals(-999.7, converter.convertKtoF(-300), 0.0001);
        assertEquals(-459.7, converter.convertKtoF(0), 0.0001);
        assertEquals(80.3, converter.convertKtoF(300), 0.0001);
    }
}
