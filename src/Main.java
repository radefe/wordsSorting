import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Get path = new Get();
        System.out.println("Vuvedete lokaciq na faila");
        String text = scanner.nextLine();
        List<List<String>> dumi = new ArrayList<>();
        int rows = 0;
        Swapper swap = new Swapper();
        String currentWord = "";
        try {
            FileReader read = new FileReader(text);
            int data = read.read();
            char caster;
            while (data != -1) {
                caster = (char) data;
                if (caster == '\r' || caster == '\n') {
                    rows++;
                }
                data = read.read();
            }
            rows++;
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rows; i++) {
            dumi.add(new ArrayList<>());
        }
        rows = 0;
        try {
            FileReader read = new FileReader(text);
            int data = read.read();
            char caster;
            while (data != -1) {
                caster = (char) data;
                if (caster == '\r' || caster == '\n') {
                    dumi.get(rows).add(currentWord);
                    rows++;
                    currentWord = "";
                } else {
                    if (caster == ' ') {
                        dumi.get(rows).add(currentWord);
                        currentWord = "";
                    } else {
                        currentWord += caster;
                    }
                }
                data = read.read();
            }
            read.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        dumi.get(rows).add(currentWord);
        int choice=1;
        while(choice!=0){
        System.out.println("Vuvedete Jelanie:\n1-Smqna na red\n2-Smqna na duma\n3-Vijte podredba\n0-Izhod i zapis");
        choice = path.choice();
        if (choice == 1) {
            System.out.println("Izberete purvi red");
            int row1 = path.choice();
            System.out.println("Izberete vtori red");
            int row2 = path.choice();
            swap.swapRow(row1, row2, dumi);
        } else if (choice == 2) {
            System.out.println("Izberete purvi red");
            int row1 = path.choice();
            System.out.println("Izberete index purva duma");
            int word1 = path.choice();
            System.out.println("Izberete vtori red");
            int row2 = path.choice();
            System.out.println("Izberete index na vtora duma");
            int word2 = path.choice();
            swap.swapWord(row1, word1, row2, word2, dumi);
        }
        else if(choice==3){
            for(int i=0; i<dumi.size(); i++){
                for (int l = 0;l<dumi.get(i).size();l++) {
                    System.out.println( dumi.get(i).get(l)+ " ");
                }
                System.out.println("\n");
            }
        }
        }

        try {
            FileWriter writer = new FileWriter(text);
            for(int i=0; i<dumi.size(); i++){
                for (int l = 0;l<dumi.get(i).size();l++) {
                    writer.write( dumi.get(i).get(l)+ " ");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}