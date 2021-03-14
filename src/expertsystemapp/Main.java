package expertsystemapp;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import expertsystem.Motor;
import expertsystem.Rule;
import expertsystem.IFact;
import expertsystem.HumanInterface;
import static expertsystemapp.FileExplorer.isNumeric;
import java.awt.TextArea;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main implements HumanInterface {

    public Scanner keyboard = new Scanner(System.in);
    public FileReaderClass fileReader = new FileReaderClass();
    public JTextArea textArea = new JTextArea();

    public Main(JTextArea TxtArea) {
        
        this.textArea = TxtArea;
        run(textArea);
    }

    public void Main(JTextArea TxtArea) {

        Main app = new Main(textArea);
        
    }

    // Funcionamiento del programa, con el ejemplo de las polígonos
    public void run(JTextArea textArea) {
        // Creación del motor
        Motor motor = new Motor(this);
        LinkedList<String> lines = new LinkedList<String>();
        lines = fileReader.reader("Rules.txt");
        // Agregar las reglas
        System.out.println(lines.size());

        for (int i = 0; i < lines.size(); i++) {
            textArea.append(lines.get(i) + "\n");
            motor.addRule(lines.get(i));
        }
        textArea.append("\n** Resolución **");
        motor.solve();
        // Resolución
        if (!JOptionPane.showInputDialog("¿Desea salir? (s/n)").equalsIgnoreCase("s")) {
            textArea.append("\n** Resolución **");
            motor.solve();
        }
        else{
        System.exit(0);
        } 
        
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    // Pide una valor entero al usuario, sin verificaciones (0 en caso de problema)
    @Override
    public int askIntValue(String question) {
        System.out.println(question);
        String answer = "";
        try {
            answer = JOptionPane.showInputDialog(question);
            if (isNumeric(answer)) {
                System.out.println(answer);
                return parseInt(answer);
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;

    }

    // Solicita un valor booleano, con sí (verdadero) o no. 
    // Se ignorarn los errores (devuelve falso)
    @Override
    public boolean askBoolValue(String question) {
        String answer = "";
        try {
            answer = JOptionPane.showInputDialog(question + " (si, no)");
            return (answer.equals("si"));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Muestra la lista de hechos de nivel >0 y por orden decreciente de nivel
    @Override
    public void printFacts(List<IFact> facts) {
        String answer = "Solución(es) encontrada(s) : \n";
        Collections.sort(facts, (IFact f1, IFact f2) -> {
            return Integer.compare(f2.getLevel(), f1.getLevel());
        });
        for (IFact f : facts) {
            if (f.getLevel() != 0) {
                answer += f.toString() + "\n";
            }
        }
        this.textArea.append(answer);
    }

    // Muestra las reglas contenidas en la base
    @Override
    public void printRules(List<Rule> rules) {
        String answer = "";
        for (Rule r : rules) {
            answer += r.toString() + "\n";
        }
        this.textArea.append(answer);
    }
}
