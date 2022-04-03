public class BrainFlowMain extends Thread{

    private ProgramState programState;

    public static void main(String[] args){
        try {
            BrainFlowGetData.getData();
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
