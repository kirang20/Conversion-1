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
}
