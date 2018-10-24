import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTemperatureConverter {

    @Parameterized.Parameter
    public double temperatureC;

    @Parameterized.Parameter(1)
    public double temperatureK;

    @Parameterized.Parameter(2)
    public double temperatureF;

    @Parameterized.Parameters
    public static Collection<Object[]> getTestsData() {
        return Arrays.asList(new Object[][] {
                {0.0, 273.2, 32.0},
                {-100.0, 173.2, -148.0},
                {-273.2, 0.0, -459.7},
                {-17.77, 255.38, 0.0}

        });
    }

    @Test
    public void testTemperatureConverter() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(temperatureF, converter.convertCtoF(temperatureC), 0.1);
        assertEquals(temperatureC, converter.convertFtoC(temperatureF), 0.1);
        assertEquals(temperatureK, converter.convertCtoK(temperatureC), 0.1);
        assertEquals(temperatureC, converter.convertKtoC(temperatureK), 0.1);
        assertEquals(temperatureF, converter.convertKtoF(temperatureK), 0.1);
        assertEquals(temperatureK, converter.convertFtoK(temperatureF), 0.1);
    }
}
