class FinancialForecast {

    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + growthRate) * futureValueRecursive(presentValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0; 
        double growthRate = 0.08;  
        int years = 5;

        double futureValue = futureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);
    }
}
