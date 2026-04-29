public class LightGrid {
    private boolean[][] gridBool;
    private int[][] gridBrightness;
    private int size;

    public LightGrid(int size) {
        this.size = size;
        gridBool = new boolean[size][size];
        gridBrightness = new int[size][size];
    }

    public void applyInstructionPart1(String instruction) {
        String[] parts = instruction.split(" ");
        int[] start, end;

        if (instruction.startsWith("toggle")) {
            start = parseCoords(parts[1]);
            end = parseCoords(parts[3]);
            for (int i = start[0]; i <= end[0]; i++) {
                for (int j = start[1]; j <= end[1]; j++) {
                    gridBool[i][j] = !gridBool[i][j];
                }
            }
        } else {
            start = parseCoords(parts[2]);
            end = parseCoords(parts[4]);
            boolean turnOn = instruction.startsWith("turn on");

            for (int i = start[0]; i <= end[0]; i++) {
                for (int j = start[1]; j <= end[1]; j++) {
                    gridBool[i][j] = turnOn;
                }
            }
        }
    }

    public void applyInstructionPart2(String instruction) {
        String[] parts = instruction.split(" ");
        int[] start, end;

        if (instruction.startsWith("toggle")) {
            start = parseCoords(parts[1]);
            end = parseCoords(parts[3]);
            for (int i = start[0]; i <= end[0]; i++) {
                for (int j = start[1]; j <= end[1]; j++) {
                    gridBrightness[i][j] += 2;
                }
            }
        } else {
            start = parseCoords(parts[2]);
            end = parseCoords(parts[4]);
            boolean turnOn = instruction.startsWith("turn on");

            for (int i = start[0]; i <= end[0]; i++) {
                for (int j = start[1]; j <= end[1]; j++) {
                    if (turnOn) {
                        gridBrightness[i][j] += 1;
                    } else {
                        gridBrightness[i][j] = Math.max(0, gridBrightness[i][j] - 1);
                    }
                }
            }
        }
    }

    private int[] parseCoords(String coord) {
        String[] nums = coord.split(",");
        return new int[]{Integer.parseInt(nums[0]), Integer.parseInt(nums[1])};
    }

    public int countLightsOn() {
        int count = 0;
        for (boolean[] row : gridBool) {
            for (boolean light : row) {
                if (light) count++;
            }
        }
        return count;
    }

    public int totalBrightness() {
        int total = 0;
        for (int[] row : gridBrightness) {
            for (int val : row) {
                total += val;
            }
        }
        return total;
    }
}
