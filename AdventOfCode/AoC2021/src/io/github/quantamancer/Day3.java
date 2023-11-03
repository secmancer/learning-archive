package io.github.quantamancer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 extends AoCPuzzle{

    public Day3() {
        super("3");
    }

    @Override
    void solvePuzzle(List<String> puzzleInput) {

        /* PART 1 */
        int[] zeros = new int[puzzleInput.get(0).length()];
        int[] ones = new int[puzzleInput.get(0).length()];
        for (String input : puzzleInput) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '0') zeros[i]++;
                else ones[i]++;
            }
        }

        long g = 0;
        long e = 0;
        for (int i = 0; i < ones.length; i++) {
            if (ones[i] > zeros[i]) {
                g += Math.pow(2, ones.length - (i + 1));
            } else {
                e += Math.pow(2, ones.length - (i + 1));
            }
        }

        long sum = g * e;

        System.out.println("Day 3 Part 1: " + sum);

        /* PART 2 */
        //PART 2
        List<String> ox_nums = new ArrayList<>(puzzleInput);
        List<String> c2_nums = new ArrayList<>(puzzleInput);

        int index = 0;
        while(ox_nums.size() > 1)
        {
            List<int[]> newList = getList(ox_nums);
            ones = newList.get(0);
            zeros = newList.get(1);
            for(int i = ox_nums.size() - 1; i >= 0; i--)
            {
                String oxyNum = ox_nums.get(i);
                if(ones[index] >= zeros[index] && oxyNum.charAt(index) == '0')
                    ox_nums.remove(i);
                else if(ones[index] < zeros[index] && oxyNum.charAt(index) == '1')
                    ox_nums.remove(i);
            }
            index++;
        }

        index = 0;
        while(c2_nums.size() > 1)
        {
            List<int[]> newList = getList(c2_nums);
            ones = newList.get(0);
            zeros = newList.get(1);
            for(int i = c2_nums.size() - 1; i >= 0; i--)
            {
                String co2Num = c2_nums.get(i);
                if(ones[index] >= zeros[index] && co2Num.charAt(index) == '1')
                    c2_nums.remove(i);
                else if(ones[index] < zeros[index] && co2Num.charAt(index) == '0')
                    c2_nums.remove(i);
            }
            index++;
        }

        long oxyNum = Integer.parseInt(ox_nums.get(0), 2);
        long co2Num = Integer.parseInt(c2_nums.get(0), 2);
        System.out.println("Day 3 Part 2: " + (oxyNum * co2Num));
    }

    public static List<int[]> getList(List<String> input)
    {
        int[] ones = new int[input.get(0).length()];
        int[] zeros = new int[input.get(0).length()];
        for(String s : input)
        {
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == '0') zeros[i]++;
                else ones[i]++;
            }
        }
        return Arrays.asList(ones, zeros);
    }
}
