package main;

public class Measurement {
  private final double amount;
  private final Unit unit;

  public Measurement(double amount, Unit unit) {
    this.amount = amount;
    this.unit = unit;
  }

  public Measurement convertTo(Unit anotherUnit) {
    if (!unit.isCompatibleWith(anotherUnit)) {
      throw new IncompatibleUnitsException();
    }
    return new Measurement(anotherUnit.fromBaseUnit(unit.toBaseUnit(amount)), anotherUnit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Measurement that = (Measurement) o;

    if (Double.compare(that.amount, amount) != 0) return false;
    return unit == that.unit;

  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(amount);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (unit != null ? unit.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Measurement{" +
            "amount=" + amount +
            ", unit=" + unit +
            '}';
  }
}
