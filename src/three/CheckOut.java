package three;

import java.io.*;
import java.util.ArrayList;

public class CheckOut {
    public static void main(String[] args) {

        File file = new File("src/three/products.csv");

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        ArrayList<String> list = new ArrayList<String>();

        try {
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    list.add(line);
                }
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Products[] table = new Products[list.size()];
        for (int i = 0; i < list.size(); i++) {
            table[i] = new Products(list.get(i).split(";")[0], list.get(i).split(";")[1], Double.parseDouble(list.get(i).split(";")[2]));
        }

        CheckOut checkout = new CheckOut();
        System.out.println("Suma wszystkich produktów wynosi " + checkout.totalPrice(table));
        System.out.println("Najdroższy produkt to " + checkout.expensiveStuff(table).getName());
    }

    double totalPrice(Products[] table) {
        double total = 0;
        for (int i = 0; i < table.length; i++) {
            total += table[i].getPrice();
        }
        return total;
    }

    Products expensiveStuff(Products[] table) {
        Products products1 = null;
        double max = 0;

        for (int i = 0; i < table.length; i++) {
            if (table[i].getPrice() > max) {
                max = table[i].getPrice();
                products1 = table[i];
            }
        }
        return products1;
    }

}
