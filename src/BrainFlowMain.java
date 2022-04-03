import java.util.Arrays;

public class BrainFlowMain extends Thread {

    private ProgramState programState;

    public static void main(String[] args){
        try {
            Cyton cyton = new Cyton();
            CytonData data = cyton.streamData(30);
            cyton.releaseSession();
            System.out.println(Arrays.toString(data.getData()));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public BrainFlowMain(ProgramState ps){
        programState = ps;
    }

    public void run(){
        while(true){
            // update programState logic code here
        }
    }
}
