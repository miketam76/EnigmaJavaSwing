import EnigmaUI.EnigmaUIFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EnigmaUIFrame enigmaUIFrame = null;
            try {
                enigmaUIFrame = new EnigmaUIFrame();
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            enigmaUIFrame.setVisible(true);
        });
    }
}