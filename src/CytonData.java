/**
 * Represents a streaming session of the Cyton, with the raw data and amount of seconds streamed
 */
public class CytonData {
    private double[] data;
    private double[] times;
    private int seconds;

    /**
     * Constructs an instant of the CytonData class
     * @param data a double[] representing the raw data from the stream
     * @param seconds an int representing the length of time of the stream
     */
    public CytonData(double[] data, int seconds) {
        this.data = data;
        this.seconds = seconds;
        this.times = new double[this.data.length];
        for (int i = 0; i < data.length; i++) {
            this.times[i] = (double)i * this.seconds / (double)this.data.length;
        }
    }

    /**
     * Constructs an empty instant of the CytonData class
     */
    public CytonData() {
        this.data = null;
        this.seconds = 0;
        this.times = null;
    }

    /**
     * Gets the data from a Cyton session
     * @return double[] representing data from session
     */
    public double[] getData() {
        return this.data;
    }

    /**
     * Gets the time length of a Cyton session
     * @return double representing length of session
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Gets the corresponding time of the data
     * @return a double[] representing the corresponding times of the data
     */
    public double[] getTimeArray() {
        return this.times;
    }
}
