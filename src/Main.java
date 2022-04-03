import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Grip Strength");
        ProgramState ps = new ProgramState();
        ProgramGUI gui = new ProgramGUI(ps);

        BrainFlowMain dataUpdater = new BrainFlowMain(ps);
        dataUpdater.start();

        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        gui.setStatusMessage("<html>Grip Strength Diagnostic. Apply electrodes as depicted.<br/>When complete, press start.</html>");
        while(!ps.hasScanStarted()){

        }
        System.out.println("Press detected"); //remove when done
        gui.setStatusMessage("Relax your lower arm on a horizontal surface. Try not to move your arm.");

    }
}
