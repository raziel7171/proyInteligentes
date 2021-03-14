package expertsystemapp;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import expertsystem.Motor;
import expertsystem.Rule;
import expertsystem.IFact;
import expertsystem.HumanInterface;
import java.util.ArrayList;
import java.util.LinkedList;
        

public class Main implements HumanInterface {
    
    public Scanner keyboard = new Scanner(System.in);
    public FileReaderClass fileReader = new FileReaderClass();
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    // Funcionamiento del programa, con el ejemplo de las polígonos
    public void run() {
        // Creación del motor
        Motor motor = new Motor(this);
        LinkedList<String> lines = new LinkedList<String>();
        lines = fileReader.reader("Rules.txt");
        // Agregar las reglas
        System.out.println(lines.size());
        
        
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
            motor.addRule(lines.get(i));
        }
        

        // Resolución
        do {
            System.out.println("\n** Resolución **");
            motor.solve();
            System.out.println("¿Desea salir? (s/n)");
        } while (!keyboard.next().equalsIgnoreCase("s"));
    }

    // Pide una valor entero al usuario, sin verificaciones (0 en caso de problema)
    @Override
    public int askIntValue(String question) {
        System.out.println(question);

        try {
            return keyboard.nextInt();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Solicita un valor booleano, con sí (verdadero) o no. 
    // Se ignorarn los errores (devuelve falso)
    @Override
    public boolean askBoolValue(String question) {
        try {
            System.out.println(question + " (si, no)");
            String res = keyboard.next();
            return (res.equals("si"));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Muestra la lista de hechos de nivel >0 y por orden decreciente de nivel
    @Override
    public void printFacts(List<IFact> facts) {
        String res = "Solución(s) encontrada(s) : \n";
        Collections.sort(facts, (IFact f1, IFact f2) -> {
            return Integer.compare(f2.getLevel(), f1.getLevel());
        });
        for (IFact f : facts) {
            if (f.getLevel() != 0) {
                res += f.toString() + "\n";
            }
        }
        System.out.println(res);
    }

    // Muestra las reglas contenidas en la base
    @Override
    public void printRules(List<Rule> rules) {
        String res = "";
        for (Rule r : rules) {
            res += r.toString() + "\n";
        }
        System.out.println(res);
    }
}
