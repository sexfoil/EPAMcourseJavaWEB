
public class PyramidBuilderModel {

    private int[][] pyramid;

    public PyramidBuilderModel() {
    }

    public int[][] getPyramid() {
        return pyramid;
    }

    private void setPyramid(int[][] pyramid) {
        this.pyramid = pyramid;
    }

    public void createPyramid(int height) {
        int base = height * 2 - 1;
        pyramid = new int[height][base];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < y + 1; x++) {
                pyramid[y][base / 2 - x] = y - x + 1;
                pyramid[y][base / 2 + x] = y - x + 1;
            }
        }
    }
}
