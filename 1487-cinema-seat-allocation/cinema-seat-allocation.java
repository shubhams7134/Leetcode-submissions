class Solution {
    private int CurrentRowPossibilityCount(HashSet<Integer> filledVal) {
        int n1=0,n2=0,n3=0;
        System.out.println(filledVal);
        if(!(filledVal.contains(2) || filledVal.contains(3) || filledVal.contains(4)|| filledVal.contains(5))) {
            n1 = 1;
        }
        if(!(filledVal.contains(6) || filledVal.contains(7) || filledVal.contains(8)|| filledVal.contains(9))) {
            n3 = 1;
        }
        if(n1 == 1  || n3 == 1) {
            return n1 + n3;
        }
        if(!(filledVal.contains(4) || filledVal.contains(5) || filledVal.contains(6)|| filledVal.contains(7))) {
            n2 = 1;
        }

        return n1 + n2 + n3;
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int i =0, len = reservedSeats.length;
        int ans = 0;
        Arrays.sort(reservedSeats, (a, b) -> Integer.compare(a[0], b[0]));
        HashSet<Integer> filledVal = new HashSet<>();
        HashSet<Integer> containsColumn = new HashSet<>();
        while(i<len) {
            filledVal.add(reservedSeats[i][1]);
            containsColumn.add(reservedSeats[i][0]);
            // System.out.println(filledVal);
            if(i==len-1 ||  reservedSeats[i][0] != reservedSeats[i+1][0]) {
                ans+=CurrentRowPossibilityCount(filledVal);
                filledVal = new HashSet<>();
                System.out.println(reservedSeats[i][0] + " " +  reservedSeats[i][1]+ " " + ans);
            }
            i++;
        }
        return ans + 2*(n-containsColumn.size());
    }
};