import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("AudioGUI");
        ProgramState ps = new ProgramState();
        ProgramGUI gui = new ProgramGUI(ps);
        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        gui.setStatusMessage("Grip Strength Diagnostic. Apply electrodes as depicted. \nWhen complete, press start.");
        while(!ps.hasScanStarted()){

        }
        System.out.println("Press detected");


        try {
            BrainFlowGetData.getData();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
