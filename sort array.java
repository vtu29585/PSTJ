class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // Move left pointer until an odd number is found
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // Move right pointer until an even number is found
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // Swap odd number on left with even number on right
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }
}
