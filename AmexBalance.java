package javamains;

import java.io.*;

public class AmexBalance {

    public static void main(String[] args) throws IOException {

        double total = 0;
        File file = new File("balanceamex.txt");
        if (file.exists()) {
            System.out.println("File exists!.");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {              
                if (line.startsWith("$")) {
                      System.out.println(":: " + line);
                    double valor = Double.valueOf(line.replace("$", "").replace(",", ""));                 
                    total += valor;
                } else if (line.startsWith("-$")) {
                      System.out.println(":: " + line);
                    double valor = Double.valueOf(line.replace("$", "").replace(",", "").replace("-", ""));
                    System.out.println(":: -" + valor);
                    total -= valor;
                }

            }

            System.out.println("Total balance :: " + total);

        }

    }

}
