package com.example.demo.coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class CSVParsing {
    //lib openCsv

    public static void main(String...args) {

        try {
            FileInputStream fin = new FileInputStream("file");
            ObjectInputStream objectInput = new ObjectInputStream(fin);
            objectInput.read();
            objectInput.close();
        }catch(FileNotFoundException fie){
            fie.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        * 1. extract header - 1st line
        * 1.1. batch process -> read first 50 lines
        * 2. read each line - split(",")
        * 3. check for format in each line - size of array after split == header length
        * 3.1. correct -> save to object
        * 3.2. incorrect -> discard & log incorrect record
        *
        *
        *
        * */
    }

}
