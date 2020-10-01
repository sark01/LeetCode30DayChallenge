class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                a[0]=hm.get(target-nums[i]);
                a[1]=i;
                break;
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return a;
    }
}