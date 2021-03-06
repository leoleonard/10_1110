package three;

import java.io.*;
import java.util.ArrayList;

public class CheckOut {
    public static void main(String[] args) {

        FileReader fileReader = null;
        try {
            File file = new File("src/three/products.csv");
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
        System.out.println("Suma wszystkich produktów wynosi " + checkout.totalPrice(table) + "pln");
        System.out.println("Najdroższy produkt to " + checkout.expensiveStuff(table).getName() + " - " + checkout.expensiveStuff(table).getPrice() + "pln");
//        System.out.println(checkout.producentWinner(table));
    }

    private double totalPrice(Products[] table) {
        double total = 0;
        for (int i = 0; i < table.length; i++) {
            total += table[i].getPrice();
        }
        return total;
    }

    private Products expensiveStuff(Products[] table) {
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

//    String producentWinner(Products[] table) {
//        String producent = null;
//        String winner = null;
//        double counter = 0;
//
//        for (int i = 0; i < table.length; i++) {
//            producent = table[i].getProducent();
//            for (int j = 0; j < table.length; j++) {
//                if (table[i].getProducent() == table[j].getProducent()) {
//                    counter++;
//                }
//            }
//        }
//        return producent;
//    }


}
