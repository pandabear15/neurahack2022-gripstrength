import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ProgramGUI {
    private JPanel rootPanel;
    private JLabel status;
    private JButton pressButton;

    boolean status_on = false;

    private final String soundName = "sfx.wav";
    private AudioInputStream audioIS;
    private Clip c = null;

    public ProgramGUI() {
        pressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status_on = !status_on;
                if(status_on){
                    setStatusMessage("Grip detected");
                }
                else{
                    if(c != null) {
                        c.close();
                    }
                    try {
                        audioIS = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                        c = AudioSystem.getClip();
                        c.open(audioIS);
                    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    }
                    c.start();
                    setStatusMessage("Grip not detected");
                }
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }

    public void setStatusMessage(String statusMessage){
        status.setText(statusMessage);
    }

    public void setButtonMessage(String buttonMessage){
        pressButton.setText(buttonMessage);
    }

    public void setButtonEnabled(boolean enable){
        pressButton.setEnabled(enable);
    }
}
