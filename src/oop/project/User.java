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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author duchi
 */
public class User {

    static File data = new File("data.vhdh");
    static ArrayList<Score> scoreArray = new ArrayList<>();
    public static void print(){
        for (Score score : scoreArray) {
            System.out.println(score.diem + " --- " +  score.level);
        }
    }
    public static ArrayList<Score> getData() {
        return scoreArray;
    }

    public static void setData(int diem, int level) {
        scoreArray.add(new Score(diem, level));
    }

    public static void openFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(data));
        String line = br.readLine();
        while (line != null) {
            int diem = Character.getNumericValue(line.charAt(0));
            int level = Character.getNumericValue(line.charAt(2));
            scoreArray.add(new Score(diem, level));
            line = br.readLine();
        }
        br.close();
    }// 0 1

    public static void saveFile() throws Exception {
        FileWriter fw = new FileWriter(data);
        String newData = "";
        for (Score score : scoreArray) {
            newData += score.diem + " " + score.level + "\n";
        }
        fw.flush();
        fw.write(newData);
        fw.close();
    }
}

class Score {

    int diem;
    int level;

    public Score(int diem, int level) {
        this.diem = diem;
        this.level = level;
    }

}
