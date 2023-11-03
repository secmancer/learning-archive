package io.github.quantamancer;

import java.util.List;

public class Day1 extends AoCPuzzle{

    public Day1() {
        super("1");
    }

    @Override
    void solvePuzzle(List<String> puzzleInput) {

        /* PART 1 */
        int increases = 0;
        /*
            Here, we are iterating through the list of inputs given. We then check
            the previous element and the current element. If the current element is
            larger, then increases is incremented by 1. The loop var i starts at 1
            since we can assume the element at index 0 is always no change.
         */
        for (int i = 1; i < puzzleInput.size(); i++) {
            int a = Integer.parseInt(puzzleInput.get(i));
            int b = Integer.parseInt(puzzleInput.get(i - 1));
            if (a > b) increases++;
        }
        System.out.println("Day 1 Part 1 Answer: " + increases);

        /* PART 2 */
        increases = 0;
        /*
            Here, we are also iterating through the list of inputs given. However, now
            we are adding three elements together and then comparing it to the previous
            element of the current one. The loop var i starts at 3 since access to the
            3 elements is necessary for calculating the first sum.
         */
        for (int i = 3; i < puzzleInput.size(); i++) {
            int a = Integer.parseInt(puzzleInput.get(i));
            int b = Integer.parseInt(puzzleInput.get(i - 3));
            increases += a > b ? 1 : 0;
        }
        System.out.println("Day 1 Part 2 Answer: " + increases);
    }
}
