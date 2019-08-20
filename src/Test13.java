public class Test13 {
    private int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int threshold;
    private int count = 0;
    private int cols;
    private int rows;
    private int[][] digitSum;


    public static void main(String[] args) {
        System.out.println(new Test13().movingCount(15, 20, 20));
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0 || threshold < 0) {
            return 0;
        }
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDight(rows, cols);
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return count;
    }

    private void dfs(boolean[][] marked, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || marked[i][j]) {
            return;
        }
        marked[i][j] = true;
        if (digitSum[i][j] > threshold) {
            return;
        }
        count++;
        for (int[] nums : next) {
            dfs(marked, i + nums[0], j + nums[1]);
        }

    }

    private void initDight(int rows, int cols) {
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < 10 && j < 10) {
                    digitSum[i][j] = i + j;
                } else {
                    int sum = 0;
                    int tempI = i;
                    int tempJ = j;
                    while (tempI > 0 || tempJ > 0) {
                        sum += tempI % 10 + tempJ % 10;
                        tempI /= 10;
                        tempJ /= 10;
                    }
                    digitSum[i][j] = sum;
                }
            }
        }
    }
}
