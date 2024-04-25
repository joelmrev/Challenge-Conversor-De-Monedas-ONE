import com.google.gson.*;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);

        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Conversor conversor = consultaMoneda.buscaConversion("MXN","USD");
//        System.out.println(conversor);

        System.out.println("---------------------------------------------------------");
        System.out.println("--- Sea bienvenida/o al Conversor de Moneda ---\n");

        String menu = """
                1) Peso Mexicano -->> Dólar
                2) Dólar -->> Peso Mexicano
                3) Won (Moneda de Corea del Sur) -->> Peso Mexicano
                4) Peso Mexicano -->> Won (Moneda de Corea del Sur)
                5) Peso Mexicano -->> Peso Colombiano
                6) Peso Colombiano -->> Peso Mexicano
                7) Peso Mexicano -->> Euro
                8) Euro -->> Peso Mexicano
                9) Salir
                
                Elija una opción válida:
                """;
        int opcion = 0;

        while (opcion != 9) {
            System.out.println(menu);
            System.out.println("---------------------------------------------------------");
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    conversor = consultaMoneda.buscaConversion("MXN","USD");
                    System.out.println("1 Peso MXN Equivale a: " + conversor.conversion_rate() + " Dólares USD");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 2:
                    conversor = consultaMoneda.buscaConversion("USD","MXN");
                    System.out.println("1 Dólar Equivale a: " + conversor.conversion_rate() + " Pesos MXN");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 3:
                    conversor = consultaMoneda.buscaConversion("KRW","MXN");
                    System.out.println("1 Won Equivale a: " + conversor.conversion_rate() + " Pesos MXN");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 4:
                    conversor = consultaMoneda.buscaConversion("MXN","KRW");
                    System.out.println("1 Peso MXN Equivale a: " + conversor.conversion_rate() + " Wones KRW");
                    System.out.println("---------------------------------------------------------");;
                    break;
                case 5:
                    conversor = consultaMoneda.buscaConversion("MXN","COP");
                    System.out.println("1 Peso MXN Equivale a: " + conversor.conversion_rate() + " Pesos COP");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 6:
                    conversor = consultaMoneda.buscaConversion("COP","MXN");
                    System.out.println("1 Peso COP Equivale a: " + conversor.conversion_rate() + " Pesos MXN");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 7:
                    conversor = consultaMoneda.buscaConversion("MXN","EUR");
                    System.out.println("1 Peso MXN Equivale a: " + conversor.conversion_rate() + " Euros");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 8:
                    conversor = consultaMoneda.buscaConversion("EUR","MXN");
                    System.out.println("1 Euro Equivale a: " + conversor.conversion_rate() + " Pesos MXN");
                    System.out.println("---------------------------------------------------------");
                    break;
                case 9:
                    System.out.println("Gracias por utilizar nuestra Aplicación.");
                    System.out.println("---------------------------------------------------------");
                    break;
                default:
                    System.out.println("Lo sentimos, esa opción no es válida.");
                    System.out.println("---------------------------------------------------------");
                    break;
            }
        }




    }
}
