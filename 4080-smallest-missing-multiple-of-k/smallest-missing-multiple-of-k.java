class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet <Integer> s = new HashSet<>();
        int ans = k;
        boolean valueFound = false;
        for(int x : nums) {
            if(x%k == 0) s.add(x);
        }
        while(!valueFound) {
            if(!s.contains(ans)) {
                valueFound = true;
                return ans;
            }
            ans+=k;
        }
        return -1;
    }
}