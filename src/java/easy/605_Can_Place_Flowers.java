class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int left  = (i == 0) ? 0 : flowerbed[i-1];
            int right = (i == flowerbed.length-1) ? 0 : flowerbed[i+1];

            if (flowerbed[i] == 0 && left == 0 && right == 0) {
                cnt++;
                flowerbed[i] = 1;
                if (cnt >= n) return true;
            }
        }
        return cnt >= n;
    }
}