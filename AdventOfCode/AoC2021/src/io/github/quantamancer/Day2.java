package io.github.quantamancer;

import java.util.List;

public class Day2 extends AoCPuzzle{

    public Day2() {
        super("2");
    }

    @Override
    void solvePuzzle(List<String> puzzleInput) {

        /* PART 1 */

        int depth = 0;
        int position = 0;

        String[] line;

        for (String currLine : puzzleInput) {
            line = currLine.split(" ");
            if (line[0].equals("forward")){
                position += Integer.parseInt(line[1]);
            } else if (line[0].equals("down")) {
                depth += Integer.parseInt(line[1]);
            } else if (line[0].equals("up")) {
                depth -= Integer.parseInt(line[1]);
            }
        }

        int sum = depth * position;

        System.out.println("Day 2 Part 1 Solution: " + sum);

        /* PART 2 */
        depth = 0;
        position = 0;
        int aim = 0;

        for (String currLine : puzzleInput) {
            line = currLine.split(" ");
            if (line[0].equals("forward")){
                position += Integer.parseInt(line[1]);
                depth += aim * Integer.parseInt(line[1]);
            } else if (line[0].equals("down")) {
                aim += Integer.parseInt(line[1]);
            } else if (line[0].equals("up")) {
                aim -= Integer.parseInt(line[1]);
            }
        }

        sum = depth * position;

        System.out.println("Day 2 Part 2 Solution: " + sum);

    }
}
