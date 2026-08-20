class Solution {
    public int[] resultArray(int[] nums) {
        int i=0,n=nums.length,j=0;
        int[] ans = new int[n];
        List<Integer> lNums = new ArrayList<>();
        List<Integer> rNums = new ArrayList<>();
        lNums.add(nums[i++]);
        rNums.add(nums[i++]);
        while(i<n) {
            int lEle = lNums.get(lNums.size()-1);
            int rEle = rNums.get(rNums.size()-1);
            if(lEle > rEle) lNums.add(nums[i++]);
            else rNums.add(nums[i++]);
        }
        for(i=0;i<lNums.size();i++) {
            ans[j++] = lNums.get(i);
        }
        for(i=0;i<rNums.size();i++) {
            ans[j++] = rNums.get(i);
        }
        return ans;
    }
}