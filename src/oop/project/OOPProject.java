/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

/**
 *
 * @author duchi
 */
public class OOPProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        User.openFile();
        User.setData(4, 5);
        User.print();
        User.saveFile();
        User.getData();
        new LevelView().setVisible(true);
        
        //tao mot cai luong (a class which implements abstract class Runnable ) 
        //sang main
        //tao 1 cai thread
        // truyen luong vao cai thread ay
        // sau do start

    }

}
