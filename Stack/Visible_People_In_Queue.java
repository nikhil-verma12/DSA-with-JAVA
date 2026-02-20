class Solution {
    public int[] canSeePersonsCount(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(nums[n-1]);
        ans[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--){
            int size = 0;
            while(!st.isEmpty() && nums[i] >= st.peek()){
                st.pop();
                size++;
            }
            if(st.size() > 0){
                size++;
            }
            ans[i] = size;
            st.push(nums[i]);
        }
        return ans;
    }
}
