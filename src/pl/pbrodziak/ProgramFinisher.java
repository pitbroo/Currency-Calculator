package pl.pbrodziak;

import java.util.List;
import java.util.Scanner;

public class ProgramFinisher {
    public Boolean finishProgram(List<Cube> listOfCube, Scanner scanner) {
        TableDisplay tableDisplay = new TableDisplay();
        boolean isContinue = true;
        System.out.println("------------------------------------------------------");
        System.out.println("Wpisz 'c' lub cokolwiek by kontynować, 'e' by zamknąć, 'p' by pokazać tablice kursów ");
        String userInput = scanner.next();

        switch (userInput){
            case "e":
                System.out.println("----------------------------------------");
                System.out.println("Dziękuje za skorzystanie, do zobaczenia!");
                isContinue = false;
                break;
            case "p":

                tableDisplay.displeyCurrencyTable(listOfCube);
                break;
        }
        return isContinue;
    }
}
