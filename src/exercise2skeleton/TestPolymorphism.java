package exercise2Skeleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TestPolymorphism {

    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("#,###.##");
        ArrayList<Material> materials = new ArrayList<>();

        method1(materials);
        method2(materials);
        method3(materials);

        Surface aSurface = new Surface("testSurface", 5.7, 5.7);

        for (int i = 0; i < materials.size(); i++) {
            String name = materials.get(i).getName();
            double req = materials.get(i).getMaterialReq(aSurface);
            double price = materials.get(i).calcTotalPrice(aSurface);
            System.out.println("Name: " + name + ", Requirement: "
                    + f.format(req) + " units, Price €" + f.format(price));
            System.out.println();
        }

    }

    private static void method1(ArrayList<Material> materials) {

        String pName;
        double price;
        int NoOfCoats;
        double NoOfSqMPerLiter;

        File myFile = new File("Files", "Paint.txt");

        try (Scanner in = new Scanner(myFile)) {
            while (in.hasNextLine()) {
                pName = in.nextLine();
                price = Double.parseDouble(in.nextLine());
                NoOfCoats = Integer.parseInt(in.nextLine());
                NoOfSqMPerLiter = Double.parseDouble(in.nextLine());

                materials.add(new Paint(pName, price, NoOfCoats, NoOfSqMPerLiter));

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Problem:" + ex.getMessage());
        }

    }
    
    private static void method2(ArrayList<Material> materials) {

        String initName;
        double initPrice;
        double initLengthPerRoll;
        double initWidthPerRoll;

        File myFile = new File("Files", "Wallpaper.txt");

        try (Scanner in = new Scanner(myFile)) {
            while (in.hasNextLine()) {
                initName = in.nextLine();
                initPrice = Double.parseDouble(in.nextLine());
                initLengthPerRoll = Double.parseDouble(in.nextLine());
                initWidthPerRoll = Double.parseDouble(in.nextLine());

                materials.add(new Wallpaper(initName, initPrice, initLengthPerRoll, initWidthPerRoll));

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Problem:" + ex.getMessage());
        }

    }
    
    private static void method3(ArrayList<Material> materials) {

        String initName;
        double initPrice;
        double coverage;

        File myFile = new File("Files", "Flooring.txt");

        try (Scanner in = new Scanner(myFile)) {
            while (in.hasNextLine()) {
                initName = in.nextLine();
                initPrice = Double.parseDouble(in.nextLine());
                coverage = Double.parseDouble(in.nextLine());

                materials.add(new Flooring(initName, initPrice, coverage));

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Problem:" + ex.getMessage());
        }

    }
}
