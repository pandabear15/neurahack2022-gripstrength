public class ProgramState {

    private boolean scanStart;
    private double[] currentReading;

    private static double THRESHOLD; //declare this

    public ProgramState(){
        scanStart = false;
    }

    public boolean hasScanStarted(){
        return scanStart;
    }

    public void scanStarted(){
        scanStart = true;
    }

    public double[] getCurrentReading(){
        return currentReading;
    }

//    private boolean meetsThreshold(){
//        return currentReading >= ProgramState.THRESHOLD;
//    }

    public void setCurrentReading(double[] reading){
//        currentReading = TransformRawData.transform(reading);
        currentReading = reading;

    }
}
