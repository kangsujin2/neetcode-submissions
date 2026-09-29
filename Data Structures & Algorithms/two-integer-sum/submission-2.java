class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] A = new int[nums.length][2];
        for (int i=0; i<nums.length; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }

        Arrays.sort(A, Comparator.comparingInt(a-> a[0]));

        int left = 0; 
        int right = nums.length - 1;
        while(left<right) {
            int curr = A[left][0] + A[right][0];
            if (curr == target) return new int[]{Math.min(A[left][1], A[right][1]), Math.max(A[left][1], A[right][1])};
            else if (curr < target) left++;
            else right--;
        }

        return new int[0];
    }
}
