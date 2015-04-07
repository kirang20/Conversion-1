package main;

public enum Unit {
  CM(UnitType.LENGTH) {
    @Override
    public double toBaseUnit(double amount) {
      return amount;
    }

    @Override
    public double fromBaseUnit(double amount) {
      return amount;
    }
  },
  INCH(UnitType.LENGTH) {
    @Override
    public double toBaseUnit(double amount) {
      return INCH_TO_CM * amount;
    }

    @Override
    public double fromBaseUnit(double amount) {
      return amount / INCH_TO_CM;
    }
  },
  CELSIUS(UnitType.TEMPERATURE) {
    @Override
    public double toBaseUnit(double amount) {
      return amount;
    }

    @Override
    public double fromBaseUnit(double amount) {
      return amount;
    }
  },
  KELVIN(UnitType.TEMPERATURE) {
    @Override
    public double toBaseUnit(double amount) {
      return amount - 273;
    }

    @Override
    public double fromBaseUnit(double amount) {
      return amount + 273;
    }
  },
  FAHRENHEIT(UnitType.TEMPERATURE) {
    @Override
    public double toBaseUnit(double amount) {
      return ((amount - 32) * 5) / 9;
    }

    @Override
    public double fromBaseUnit(double amount) {
      return (amount * 9 / 5) + 32;
    }
  };

  Unit(UnitType type) {
    this.type = type;
  }

  static final double INCH_TO_CM = 2.54;
  private UnitType type;

  public abstract double toBaseUnit(double amount);

  public abstract double fromBaseUnit(double amount);

  public boolean isCompatibleWith(Unit anotherUnit) {
    return type.equals(anotherUnit.type);
  }
}
