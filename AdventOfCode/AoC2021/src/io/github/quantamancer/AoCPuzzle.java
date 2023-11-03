package io.github.quantamancer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AoCPuzzle {

    public AoCPuzzle(String day) {
        File file = new File("res/day" + day + ".txt");
        if(!file.exists()) {
            System.err.println("File doesn't exist!");
            return;
        }
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException e)
        {
            System.err.println("File not found!");
            return;
        }
        List<String> puzzleInputs = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) puzzleInputs.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        solvePuzzle(puzzleInputs);

    }

    abstract void solvePuzzle(List<String> puzzleInput);

}
