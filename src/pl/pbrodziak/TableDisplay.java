package pl.pbrodziak;

import java.util.List;

public class TableDisplay {
    public void displeyCurrencyTable(List<Cube> cubeList) {
        System.out.println("######################TABLICA KURSÓW###################");
        System.out.println("*******************************************************");
        for (int i = 0; i < cubeList.size(); i++) {
            if (i % 3 == 0) {
                System.out.println();
            } else {
                System.out.print("       ");
            }
            System.out.print("Numer : " + (i + 1) + ", ");
            System.out.print("kurs: " + NumberRounder.roundedToXDecimalPlaces(cubeList.get(i).rate, 4));
            System.out.print(", waluta: " + cubeList.get(i).currency);
        }
        System.out.println();
        System.out.println("*******************************************************");

    }
}
