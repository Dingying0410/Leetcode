class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(F, B);
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        if (area1 <= 0)
            return Math.max(area2, 0);
        if (area2 <= 0)
            return Math.max(area1, 0);
        if (right < left || top < bottom)
            return area1 + area2;
        int intersection = (right - left) * (top - bottom);
        return area1 + area2 - intersection;
    }

}