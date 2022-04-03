public class ProgramState {

    private boolean scanStart;
    private CytonData currentReading = new CytonData();

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

    private CytonData getCurrentReading(){
        return currentReading;
    }

//    private boolean meetsThreshold(){
//        return currentReading >= ProgramState.THRESHOLD;
//    }

    public void setCurrentReading(CytonData reading){
        currentReading = reading;
    }
}
