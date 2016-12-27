package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by TuringMac on 2016/12/27.
 */
public class PlainTextReader {
    protected File file;
    protected JTable displayTable;
    protected char[] seperators;

    public PlainTextReader(File file, JTable displayTable, String separator) {
        this.file = file;
        this.displayTable = displayTable;
        this.seperators = separator.toCharArray();
    }

    public void read() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String textString;
        String regex = "";
        for(char c : seperators) {
            regex += "|";
            if (c == '.' || c == '|' || c == '*' || c == '+')
                regex += "\\\\";
            else if (c == '\\')
                regex += "\\\\";
            regex += c;
        }
        regex = regex.substring(1, regex.length());
        while((textString = bufferedReader.readLine()) != null) {
            String[] attributeList = textString.split(regex);
            for(String a : attributeList)
                System.out.print(a + "\t");
            System.out.println();
        }
    }
}
