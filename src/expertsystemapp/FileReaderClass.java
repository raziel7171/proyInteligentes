/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystemapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class FileReaderClass {

    public static LinkedList<String> reader(String path) {

        File file = new File(path);
        LinkedList<String> content = new LinkedList<String>(); 
        try {
            Scanner scan = new Scanner(file);
            
            while (scan.hasNextLine()) {
                content.add(scan.nextLine());
                
            }
            System.out.println(content.size());
            return content;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado o no legible");
        } finally {
            return content;
        }

    }
}
