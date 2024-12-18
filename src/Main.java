import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String baseCurrency = "USD";
            ExchangeRateProvider provider = new ExchangeRateProvider();
            CurrencyData data = provider.getExchangeRates(baseCurrency);
            CurrencyConverter converter = new CurrencyConverter(data);
            double amount = 0, convertedAmount = 0;
            while (true){
            System.out.println("coversor de monedas:");
            System.out.println("1: dolares USD a Soles Peruanos");
            System.out.println("2: Soles Peruanos a dolares USD");
            System.out.println("3: dolares USD a Pesos Argentinos");
            System.out.println("4: Pesos Argentinos a dolares USD");
            System.out.println("5: dolares USD a Real Brasileño");
            System.out.println("6: Real Brasileño a dolares USD ");
            System.out.println("7: Salir");
            int option = scanner.nextInt();
            if (option > 7) {
                System.out.println("Elija una opcion valida.");
                System.out.println("------------------------");
            } else {
                switch (option) {
                    case 1:
                        System.out.println("Ingrese el monto a convertir:");
                        amount = scanner.nextDouble();
                        convertedAmount = converter.convert("USD", "PEN", amount);
                        System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, "PEN");
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a convertir:");
                        amount = scanner.nextDouble();
                        convertedAmount = converter.convert("PEN", "USD", amount);
                        System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, "USD");
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a convertir:");
                        amount = scanner.nextDouble();
                        convertedAmount = converter.convert("USD", "ARS", amount);
                        System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, "ARS");
                        break;
                    case 4:
                        System.out.println("Ingrese el monto a convertir:");
                        amount = scanner.nextDouble();
                        convertedAmount = converter.convert("ARS", "USD", amount);
                        System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, "USD");
                        break;
                    case 5:
                        System.out.println("Ingrese el monto a convertir:");
                        amount = scanner.nextDouble();
                        convertedAmount = converter.convert("USD", "BRL", amount);
                        System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, "BRL");
                        break;
                    case 6:
                        System.out.println("Ingrese el monto a convertir:");
                        amount = scanner.nextDouble();
                        convertedAmount = converter.convert("BRL", "USD", amount);
                        System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, "USD");
                        break;
                    case 7:
                        System.out.println("Chau");
                        System.exit(0);
                        break;
                }
            }}
        } catch (Exception e) {
            System.err.println("Error ingrese un monto valido: \n" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
