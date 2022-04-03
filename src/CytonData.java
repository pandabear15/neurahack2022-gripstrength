/**
 * Represents a streaming session of the Cyton, with the raw data and amount of seconds streamed
 */
public class CytonData {
    private double[] data;
    private double seconds;

    /**
     * Constructs an instant of the CytonData class
     * @param data a double[] representing the raw data from the stream
     * @param seconds a double representing the length of time of the stream
     */
    public CytonData(double[] data, double seconds) {
        this.data = data;
        this.seconds = seconds;
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
    public double getSeconds() {
        return this.seconds;
    }
}
