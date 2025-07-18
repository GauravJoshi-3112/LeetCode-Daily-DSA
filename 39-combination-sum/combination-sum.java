class Solution {
    List<List<Integer>> result;

    public void combinationSumHelp(int[] candidates,int index, int target, ArrayList<Integer> list) {
        if (target <  0 || index >= candidates.length) return;
        else if (target == 0) {
            result.add(new ArrayList<>(list));
        } else {
            combinationSumHelp(candidates, index+1, target, list);
            list.add(candidates[index]);
            combinationSumHelp(candidates, index, target - candidates[index], list);
            list.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSumHelp(candidates, 0, target, new ArrayList<>());
        return result;
    }
}