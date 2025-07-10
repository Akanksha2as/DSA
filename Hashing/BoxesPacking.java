import java.util.*;

public class BoxesPacking {

    static class Box implements Comparable<Box> {
        int w, h, d;

        Box(int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
        }

        // Sort by width, then height, then depth
        @Override
        public int compareTo(Box other) {
            if (this.w != other.w) return this.w - other.w;
            if (this.h != other.h) return this.h - other.h;
            return this.d - other.d;
        }

        // Check if this box can fit into another
        boolean canFitInto(Box other) {
            return this.w < other.w && this.h < other.h && this.d < other.d;
        }

        @Override
        public String toString() {
            return "(" + w + "," + h + "," + d + ")";
        }
    }

    // Check if all boxes can be nested
    public static boolean canNestAllBoxes(List<Box> boxes) {
        Collections.sort(boxes);
        for (int i = 0; i < boxes.size() - 1; i++) {
            if (!boxes.get(i).canFitInto(boxes.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(3, 4, 5));
        boxes.add(new Box(2, 3, 4));
        boxes.add(new Box(1, 2, 3));

        System.out.println("Can all boxes be nested? " + (canNestAllBoxes(boxes) ? "Yes" : "No"));
    }
}
