public class HealthRecord {

    // Instance field
    private int height;

    // Constants
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // Static fields (class-level statistics)
    private static int tallestHeight = Integer.MIN_VALUE;
    private static int shortestHeight = Integer.MAX_VALUE;

    private static int counter = 0;          // number of created objects
    private static double averageHeight = 0; // average height of all students

    // Constructor
    public HealthRecord(int height) {
        setHeight(height);
    }

    // Setter
    public void setHeight(int height) {

        // Validation
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        // Update counter
        counter++;

        // Update average height
        // newAvg = (oldAvg * (n-1) + newHeight) / n
        averageHeight =
                (averageHeight * (counter - 1) + this.height) / counter;

        // Update tallest height
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }

        // Update shortest height
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }
    }

    // Getters
    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static int getCounter() {
        return counter;
    }

    public static double getAverageHeight() {
        return averageHeight;
    }

    // Display methods
    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("Number of students: " + getCounter());
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("The average height (cm): " + getAverageHeight());
    }
}
