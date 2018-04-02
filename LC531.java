class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0 || picture[0].length == 0)
            return 0;
        int col0 = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    if (j == 0) {
                        col0++;
                    } else {
                        if (picture[0][j] <= 'X' && picture[0][j] != 'V')
                            picture[0][j]++;
                    }
                    if (picture[i][0] <= 'X' && picture[i][0] != 'V')
                        picture[i][0]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] <= 'C') {
                    if (j == 0) {
                        if (col0 == 1 && (picture[i][0] == 'C' || picture[i][0] == 'X'))
                            count++;
                    } else {
                        if ((picture[0][j] == 'C' || picture[0][j] == 'X') && (picture[i][0] == 'C' || picture[i][0] == 'X'))
                            count++;
                    }
                }
            }
        }
        return count;
    }
}