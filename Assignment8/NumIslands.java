package Assignment8;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    numIslands(grid, i, j);
                }
            }
        }
        return res;
    }

    void numIslands(char[][] grid, int i, int j) {
        if (grid[i][j] == '2'){
            return;
        }
        if (grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '2';
        if (i > 0) {
            numIslands(grid, i - 1, j);
        }
        if (j > 0) {
            numIslands(grid, i, j - 1);
        }
        if (i < grid.length - 1) {
            numIslands(grid, i + 1, j);
        }
        if (j < grid[0].length - 1) {
            numIslands(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        NumIslands ni = new NumIslands();
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(ni.numIslands(grid));

    }
}
