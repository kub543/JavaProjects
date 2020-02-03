public class CelsiuseConverter implements Converter {

    @Override
    public double calculate(double temperature) {
        return (temperature - 32) / 1.8000;
    }
}
