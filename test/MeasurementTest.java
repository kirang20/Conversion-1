import main.IncompatibleUnitsException;
import main.Measurement;
import main.Unit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeasurementTest {
  @Test
  public void shouldConvertFromSubUnitToBaseUnit() {
    Measurement measurement = new Measurement(2, Unit.INCH);

    Measurement convertedMeasurement = measurement.convertTo(Unit.CM);

    assertEquals(new Measurement(5.08, Unit.CM), convertedMeasurement);
  }

  @Test
  public void shouldConvertBaseUnitToSubUnit() {
    Measurement measurement = new Measurement(2.54, Unit.CM);

    Measurement convertedMeasurement = measurement.convertTo(Unit.INCH);

    assertEquals(new Measurement(1, Unit.INCH), convertedMeasurement);
  }

  @Test
  public void shouldConvertFromSubUnitToSubUnit() {
    Measurement measurement = new Measurement(2, Unit.INCH);

    Measurement convertedMeasurement = measurement.convertTo(Unit.INCH);

    assertEquals(new Measurement(2, Unit.INCH), convertedMeasurement);
  }

  @Test
  public void shouldConvertBaseUnitToBaseUnit() {
    Measurement measurement = new Measurement(2, Unit.CM);

    Measurement convertedMeasurement = measurement.convertTo(Unit.CM);

    assertEquals(new Measurement(2, Unit.CM), convertedMeasurement);
  }

  @Test
  public void shouldConvertCelsiusToKelvin() {
    Measurement measurement = new Measurement(273, Unit.CELSIUS);

    Measurement convertedMeasurement = measurement.convertTo(Unit.KELVIN);

    assertEquals(new Measurement(546, Unit.KELVIN), convertedMeasurement);
  }

  @Test
  public void shouldConvertFahrenheitToKelvin() {
    Measurement measurement = new Measurement(-40, Unit.FAHRENHEIT);

    Measurement convertedMeasurement = measurement.convertTo(Unit.KELVIN);

    assertEquals(new Measurement(233, Unit.KELVIN), convertedMeasurement);
  }

  @Test
  public void shouldConvertFahrenheitToCelsius() {
    Measurement measurement = new Measurement(-40, Unit.FAHRENHEIT);

    Measurement convertedMeasurement = measurement.convertTo(Unit.CELSIUS);

    assertEquals(new Measurement(-40, Unit.CELSIUS), convertedMeasurement);
  }

  @Test(expected = IncompatibleUnitsException.class)
  public void shouldHandleIncompatibleUnitTypes() {
    Measurement measurement = new Measurement(2, Unit.CM);

    measurement.convertTo(Unit.CELSIUS);
  }

}
