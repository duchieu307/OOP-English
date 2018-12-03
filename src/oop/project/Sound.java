/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Sound implements LineListener {

    private File audioFile = null;
    private AudioInputStream audioStream = null;
    private AudioFormat format = null;
    private DataLine.Info info = null;
    private Clip audioClip = null;
    private String filePath = null;

    public Sound(String filePath) {
        this.filePath = filePath;
        this.audioFile = new File(filePath);
        try {
            this.audioStream = AudioSystem.getAudioInputStream(audioFile);
            this.format = audioStream.getFormat();
            this.info = new DataLine.Info(Clip.class, this.format);
            this.audioClip = (Clip) AudioSystem.getLine(this.info);
            audioClip.open(audioStream);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("er while create");
        }

    }

    public void play() {
        if (this.audioClip.isActive()) {
            System.out.println("playing");
        } else {
            this.audioClip.start();
        }
    }
    

    public void pause() {
        this.audioClip.stop();
        System.out.println("paused");
    }

    public void stop() {
        System.out.println("stopped");
        this.audioClip.stop();
        this.audioFile = new File(filePath);
        try {
            this.audioStream = AudioSystem.getAudioInputStream(audioFile);
            this.format = audioStream.getFormat();
            this.info = new DataLine.Info(Clip.class, this.format);
            this.audioClip = (Clip) AudioSystem.getLine(this.info);
            audioClip.open(audioStream);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public int getFramePosition() { // vi tri hien tai dang phat nhac 
        return (int) (this.audioClip.getMicrosecondPosition()/1000000);
    }

    public int getFrameLength() { // do dai cua file nhac tinh theo second
        
        return (int) (this.audioClip.getMicrosecondLength()/1000000);
    }

    @Override
    public void update(LineEvent event) {
        System.out.println(this.audioClip.getFramePosition());
    }
}
