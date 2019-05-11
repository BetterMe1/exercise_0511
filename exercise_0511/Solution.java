package exercise.exercise_0511;


/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationHelper(result,list,candidates,target,0);
        return result;
    }
    private void combinationHelper (
            List<List<Integer>> result,List<Integer> list,
            int[] candidates,int target,int i){
        if(target < 0){
            return;
        }else if(target == 0){
            result.add(list);
            return;
        }else{
            for(int j=i; j<candidates.length &&
                    candidates[j]<=target; j++){
                //深拷贝
                List<Integer> tmp=new ArrayList<>(list);
                tmp.add(candidates[j]);
                combinationHelper(result,tmp,candidates,target-candidates[j],j);
            }
        }
    }
}
*/

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationHelper(result,list,candidates,target,0);
        return result;
    }
    private void combinationHelper(List<List<Integer>> result,
                                   List<Integer> list,int[] candidates,
                                   int target,int i){
        if(target < 0){
            return;
        }else if(target == 0){
            if(!result.contains(list)){
                result.add(list);
            }
            return;
        }else{
            for(int j=i; j<candidates.length &&
                    candidates[j]<=target; j++){
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(candidates[j]);
                combinationHelper(result,tmp,candidates,
                        target-candidates[j],j+1);
            }
        }
    }
}