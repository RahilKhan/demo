package example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class SumOfNumbers {


    public static void main(String... args) {

        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = new int[]{2, 3, 5};
        Arrays.sort(candidates);
        log.info("candidates.length -> {}",candidates.length);

        backtrack(candidates, result, new ArrayList<>(), 8, 0);
        log.info("{} ->- {}", candidates, result);
    }


    public static void backtrack(int[] candidates, List<List<Integer>> result, List<Integer> temp, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            temp.add(candidates[i]);
            backtrack(candidates, result, temp, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
//        log.info("{} => {}", candidates, result);
    }

}
