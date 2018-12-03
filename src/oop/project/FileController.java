/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author duchi
 */
public class FileController {

    private String audio_path = "src//oop//project//data//1.wav";
    private String text_path = "src//oop//project//data//1.txt";
    String diem = "";

    public String getAudio_path() {
        return audio_path;
    }

    public String getText_path() {
        return text_path;
    }

    public FileController(int lvl) {
        File testFile1 = new File("src//oop//project//data//" + lvl + ".txt");
        File testFile2 = new File("src//oop//project//data//" + lvl + ".wav");
        if (testFile1.exists() && testFile2.exists()) {
            audio_path = "src//oop//project//data//" + lvl + ".wav";
            text_path = "src//oop//project//data//" + lvl + ".txt";
        }

    }

    public String check(String answer) throws FileNotFoundException, IOException {
        answer = answer.replace("\n", " ");
        String[] ansArr = answer.split(" ");

        //doc file
        String file = "";
        String line = null; //dong
        FileReader fileReader = null; //doc file
        BufferedReader bufReader = null; //bo dem
        fileReader = new FileReader(getText_path());
        bufReader = new BufferedReader(fileReader);
        line = bufReader.readLine();
        while (line != null) {
            file += line;
            file += " ";
            line = bufReader.readLine();
        }
        fileReader.close();

        file = file.replace("/n", " ");
        String[] fileArr = file.split(" ");
//        for (int i = 0; i < fileArr.length; i++) {
//            System.out.print(fileArr[i]);
//        }

        //so sanh 2 cái string 
        boolean[] ans = new boolean[fileArr.length];;
        String result = "<html><h3>Result:</h3>";
float count = 0;
        for (int j = 0; j < ansArr.length; j++) {
            boolean match = false;
            for (int i = 0; i < fileArr.length; i++) {
                if (ansArr[j].equalsIgnoreCase(fileArr[i])) {
                    match = true;
                  count++;
                }
                System.out.println(ansArr[j]);
                System.out.println(fileArr[i]);

            }
            result += match ? ("<b>" + ansArr[j] + " " + "</b>") : ("<i>" + ansArr[j] + " " + "</i>");
        }
        count =  count / fileArr.length  *10;
        diem = String.format("%.2f", count);
        
        result += "</html>";

        return result;

    }

    public String getScript() throws FileNotFoundException, IOException {
        String text = "";
        String line = null; //dong
        FileReader fileReader = null; //doc file
        BufferedReader bufReader = null; //bo dem
        fileReader = new FileReader(getText_path());
        bufReader = new BufferedReader(fileReader);
        line = bufReader.readLine();
        while (line != null) {
            text += line;
            text += "\n";
            line = bufReader.readLine();
        }
        fileReader.close();

        return text;
    }

    public String getDiem() {
        return diem;
    }

    
}
