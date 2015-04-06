package main;

public enum Unit {
  CM {
    @Override
    public double toBaseUnit(double amount) {
      return amount;
    }
  },
  INCH {
    @Override
    public double toBaseUnit(double amount) {
      return INCH_TO_CM * amount;
    }
  };

  static final double INCH_TO_CM = 2.54;

  public abstract double toBaseUnit(double value);
}
