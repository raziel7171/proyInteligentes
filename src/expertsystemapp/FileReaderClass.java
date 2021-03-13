/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystemapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class FileReaderClass {

    public static String reader(String path) {

        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            String content = "";
            while (scan.hasNextLine()) {
                content = content.concat(scan.nextLine() + "\n");
            }
            System.out.println(content);
            return content;                   
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado o no legible");
        } finally {
            return "";
        }

    }
}
