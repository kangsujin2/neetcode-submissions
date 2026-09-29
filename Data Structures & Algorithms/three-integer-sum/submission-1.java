class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i=0; i<n; i++) {
            if(nums[i] > 0) break;
            if (i>0 && nums[i] == nums[i-1]) continue;
            
            int temp = -nums[i];
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == temp) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left<right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
                else if (twoSum < temp){
                    left++;
                }
                else {
                    right--;
                }
                
            }
        }

        return res;

    }
}
