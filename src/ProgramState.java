public class ProgramState {

    private boolean scanStart;
    private double currentReading = -1;

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

    private double getCurrentReading(){
        return currentReading;
    }

    private boolean meetsThreshold(){
        return currentReading >= ProgramState.THRESHOLD;
    }

    private void setCurrentReading(double reading){
        currentReading = reading;
    }
}
