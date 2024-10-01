package EnigmaUI;

import EnigmaCore.EnigmaCore;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;
import java.util.Objects;

import static java.awt.Color.BLACK;

public class EnigmaUIFrame extends JFrame {

    private final EnigmaCore core;

    private static final String PLUG_SYMBOL = "<->";

    private String plugCable1;
    private String plugCable2;
    private String plugCable3;
    private String plugCable4;
    private String plugCable5;
    private String plugCable6;
    private String plugCable7;
    private String plugCable8;
    private String plugCable9;
    private String plugCable10;

    // Swing components
    private JComboBox cboRotor3;
    private JComboBox cboRotor2;
    private JComboBox cboRotor1;
    private JTextField txtInput;
    private JTextField txtResult;
    private JCheckBox bCheckBox;
    private JCheckBox aCheckBox;
    private JCheckBox cCheckBox;
    private JCheckBox dCheckBox;
    private JCheckBox eCheckBox;
    private JCheckBox fCheckBox;
    private JCheckBox gCheckBox;
    private JCheckBox hCheckBox;
    private JCheckBox iCheckBox;
    private JCheckBox jCheckBox;
    private JCheckBox kCheckBox;
    private JCheckBox lCheckBox;
    private JCheckBox mCheckBox;
    private JCheckBox nCheckBox;
    private JCheckBox oCheckBox;
    private JCheckBox pCheckBox;
    private JCheckBox qCheckBox;
    private JCheckBox rCheckBox;
    private JCheckBox sCheckBox;
    private JCheckBox tCheckBox;
    private JCheckBox uCheckBox;
    private JCheckBox vCheckBox;
    private JCheckBox wCheckBox;
    private JCheckBox xCheckBox;
    private JCheckBox yCheckBox;
    private JCheckBox zCheckBox;
    private JButton btnEncode;
    private JButton btnDecode;
    private JPanel panelMain;
    private JPanel panelRotors;
    private JPanel panelMessageIO;
    private JPanel panelPlugBoard;
    private JPanel panelButtons;
    private JButton btnPlugCable1;
    private JButton btnPlugCable2;
    private JButton btnPlugCable3;
    private JButton btnPlugCable4;
    private JButton btnPlugCable5;
    private JButton btnPlugCable6;
    private JButton btnPlugCable7;
    private JButton btnPlugCable8;
    private JButton btnPlugCable9;
    private JButton btnPlugCable10;
    private JPanel panelPlugCable;
    private JButton btnResetConfig;

    public EnigmaUIFrame() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        core = new EnigmaCore();

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        setContentPane(panelMain);
        setTitle("Enigma Machina");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Reset configuration to default
        resetPlugConfiguration();

        // Remove all mouse listeners on checkboxes to make them read only
        aCheckBox.removeMouseListener(aCheckBox.getMouseListeners()[0]);
        bCheckBox.removeMouseListener(bCheckBox.getMouseListeners()[0]);
        cCheckBox.removeMouseListener(cCheckBox.getMouseListeners()[0]);
        dCheckBox.removeMouseListener(dCheckBox.getMouseListeners()[0]);
        eCheckBox.removeMouseListener(eCheckBox.getMouseListeners()[0]);
        fCheckBox.removeMouseListener(fCheckBox.getMouseListeners()[0]);
        gCheckBox.removeMouseListener(gCheckBox.getMouseListeners()[0]);
        hCheckBox.removeMouseListener(hCheckBox.getMouseListeners()[0]);
        iCheckBox.removeMouseListener(iCheckBox.getMouseListeners()[0]);
        jCheckBox.removeMouseListener(jCheckBox.getMouseListeners()[0]);
        kCheckBox.removeMouseListener(kCheckBox.getMouseListeners()[0]);
        lCheckBox.removeMouseListener(lCheckBox.getMouseListeners()[0]);
        mCheckBox.removeMouseListener(mCheckBox.getMouseListeners()[0]);
        nCheckBox.removeMouseListener(nCheckBox.getMouseListeners()[0]);
        oCheckBox.removeMouseListener(oCheckBox.getMouseListeners()[0]);
        pCheckBox.removeMouseListener(pCheckBox.getMouseListeners()[0]);
        qCheckBox.removeMouseListener(qCheckBox.getMouseListeners()[0]);
        rCheckBox.removeMouseListener(rCheckBox.getMouseListeners()[0]);
        sCheckBox.removeMouseListener(sCheckBox.getMouseListeners()[0]);
        tCheckBox.removeMouseListener(tCheckBox.getMouseListeners()[0]);
        uCheckBox.removeMouseListener(uCheckBox.getMouseListeners()[0]);
        vCheckBox.removeMouseListener(vCheckBox.getMouseListeners()[0]);
        wCheckBox.removeMouseListener(wCheckBox.getMouseListeners()[0]);
        xCheckBox.removeMouseListener(xCheckBox.getMouseListeners()[0]);
        yCheckBox.removeMouseListener(yCheckBox.getMouseListeners()[0]);
        zCheckBox.removeMouseListener(zCheckBox.getMouseListeners()[0]);

        // Listener for Encode button
        btnEncode.addActionListener(e -> {
            encodeMsg();
        });

        // Listener for Decode button
        btnDecode.addActionListener(e -> {
            decodeMsg();
        });

        // Action listeners for plug cable buttons starts here
        btnPlugCable1.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable1());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable1(input);
                    core.setPlugBoard(String.valueOf(getPlugCable1().charAt(0)), String.valueOf(getPlugCable1().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable1().charAt(4)), String.valueOf(getPlugCable1().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable1.setEnabled(false);
                    btnPlugCable1.setToolTipText(getPlugCable1());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable2.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable2());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable2(input);
                    core.setPlugBoard(String.valueOf(getPlugCable2().charAt(0)), String.valueOf(getPlugCable2().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable2().charAt(4)), String.valueOf(getPlugCable2().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable2.setEnabled(false);
                    btnPlugCable2.setToolTipText(getPlugCable2());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable3.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable3());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable3(input);
                    core.setPlugBoard(String.valueOf(getPlugCable3().charAt(0)), String.valueOf(getPlugCable3().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable3().charAt(4)), String.valueOf(getPlugCable3().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable3.setEnabled(false);
                    btnPlugCable3.setToolTipText(getPlugCable3());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable4.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable4());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable4(input);
                    core.setPlugBoard(String.valueOf(getPlugCable4().charAt(0)), String.valueOf(getPlugCable4().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable4().charAt(4)), String.valueOf(getPlugCable4().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable4.setEnabled(false);
                    btnPlugCable4.setToolTipText(getPlugCable4());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable5.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable5());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable5(input);
                    core.setPlugBoard(String.valueOf(getPlugCable5().charAt(0)), String.valueOf(getPlugCable5().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable5().charAt(4)), String.valueOf(getPlugCable5().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable5.setEnabled(false);
                    btnPlugCable5.setToolTipText(getPlugCable5());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable6.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable6());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable6(input);
                    core.setPlugBoard(String.valueOf(getPlugCable6().charAt(0)), String.valueOf(getPlugCable6().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable6().charAt(4)), String.valueOf(getPlugCable6().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable6.setEnabled(false);
                    btnPlugCable6.setToolTipText(getPlugCable6());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable7.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable7());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable7(input);
                    core.setPlugBoard(String.valueOf(getPlugCable7().charAt(0)), String.valueOf(getPlugCable7().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable7().charAt(4)), String.valueOf(getPlugCable7().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable7.setEnabled(false);
                    btnPlugCable7.setToolTipText(getPlugCable7());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable8.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable8());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable8(input);
                    core.setPlugBoard(String.valueOf(getPlugCable8().charAt(0)), String.valueOf(getPlugCable8().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable8().charAt(4)), String.valueOf(getPlugCable8().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable8.setEnabled(false);
                    btnPlugCable8.setToolTipText(getPlugCable8());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable9.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable9());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable9(input);
                    core.setPlugBoard(String.valueOf(getPlugCable9().charAt(0)), String.valueOf(getPlugCable9().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable9().charAt(4)), String.valueOf(getPlugCable9().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable9.setEnabled(false);
                    btnPlugCable9.setToolTipText(getPlugCable9());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnPlugCable10.addActionListener(e -> {
            boolean alreadySet = false;
            int selection = promptPlugCableChange(getPlugCable10());

            if (selection == JOptionPane.YES_OPTION) {
                String input = inputPlugCableConfig();
                alreadySet = checkPlugCableConfig(input);
                if (!alreadySet) {
                    setPlugCable10(input);
                    core.setPlugBoard(String.valueOf(getPlugCable10().charAt(0)), String.valueOf(getPlugCable10().charAt(4)));
                    core.setPlugBoard(String.valueOf(getPlugCable10().charAt(4)), String.valueOf(getPlugCable10().charAt(0)));
                    updatePlugBoard(input.charAt(0));
                    updatePlugBoard(input.charAt(4));
                    btnPlugCable10.setEnabled(false);
                    btnPlugCable10.setToolTipText(getPlugCable10());
                } else {
                    JOptionPane.showMessageDialog(null,
                            input + " is already set. Setting not changed",
                            "Already set",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            System.out.println(core);
        });

        btnResetConfig.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null,
                    "This will reset all plug cable and plugboard configuration.\n" +
                            "Confirm?",
                    "Reset plug configuration",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                resetPlugConfiguration();
            }
        });
    }

    /**
     * Set rotor settings
     */
    public void setRotors() {
        int rotor1 = Integer.parseInt(Objects.requireNonNull(this.cboRotor1.getSelectedItem()).toString());
        int rotor2 = Integer.parseInt(Objects.requireNonNull(this.cboRotor2.getSelectedItem()).toString());
        int rotor3 = Integer.parseInt(Objects.requireNonNull(this.cboRotor3.getSelectedItem()).toString());
        core.setRotor1Pos(rotor1);
        core.setRotor2Pos(rotor2);
        core.setRotor3Pos(rotor3);
    }

    /**
     * Encode message
     */
    public void encodeMsg() {
        setRotors();
        if (!txtInput.getText().isEmpty()) {
            txtResult.setText(core.encryptMessage(txtInput.getText().toUpperCase().trim()));
        }
        updateRotorStatus();
    }

    /**
     * Decode message
     */
    public void decodeMsg() {
        setRotors();
        if (!txtInput.getText().isEmpty()) {
            txtResult.setText(core.decryptMessage(txtInput.getText().toUpperCase().trim()));
        }
        updateRotorStatus();
    }

    /**
     * Update rotor status on UI
     */
    public void updateRotorStatus() {
        cboRotor1.setSelectedItem(Integer.toString(core.getRotor1Pos()));
        cboRotor2.setSelectedItem(Integer.toString(core.getRotor2Pos()));
        cboRotor3.setSelectedItem(Integer.toString(core.getRotor3Pos()));
        System.out.println(core.getRotor1Pos() + " " + core.getRotor2Pos() + " " + core.getRotor3Pos());
    }

    boolean checkPlugCableConfig(String input) {
        boolean alreadySet = false;

        if (input.length() == getPlugCable1().length()) {
            if (input.charAt(0) == getPlugCable1().charAt(0) || input.charAt(0) == getPlugCable1().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable2().length()) {
            if (input.charAt(0) == getPlugCable2().charAt(0) || input.charAt(0) == getPlugCable2().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable3().length()) {
            if (input.charAt(0) == getPlugCable3().charAt(0) || input.charAt(0) == getPlugCable3().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable4().length()) {
            if (input.charAt(0) == getPlugCable4().charAt(0) || input.charAt(0) == getPlugCable4().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable5().length()) {
            if (input.charAt(0) == getPlugCable5().charAt(0) || input.charAt(0) == getPlugCable5().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable6().length()) {
            if (input.charAt(0) == getPlugCable6().charAt(0) || input.charAt(0) == getPlugCable6().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable7().length()) {
            if (input.charAt(0) == getPlugCable7().charAt(0) || input.charAt(0) == getPlugCable7().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable8().length()) {
            if (input.charAt(0) == getPlugCable8().charAt(0) || input.charAt(0) == getPlugCable8().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable9().length()) {
            if (input.charAt(0) == getPlugCable9().charAt(0) || input.charAt(0) == getPlugCable9().charAt(4)) {
                alreadySet = true;
            }
        }

        if (input.length() == getPlugCable10().length()) {
            if (input.charAt(0) == getPlugCable10().charAt(0) || input.charAt(0) == getPlugCable10().charAt(4)) {
                alreadySet = true;
            }
        }

        return alreadySet;
    }

    public String getPlugCable1() {
        return plugCable1;
    }

    public void setPlugCable1(String plugCable1) {
        this.plugCable1 = plugCable1;
    }

    public String getPlugCable2() {
        return plugCable2;
    }

    public void setPlugCable2(String plugCable2) {
        this.plugCable2 = plugCable2;
    }

    public String getPlugCable3() {
        return plugCable3;
    }

    public void setPlugCable3(String plugCable3) {
        this.plugCable3 = plugCable3;
    }

    public String getPlugCable4() {
        return plugCable4;
    }

    public void setPlugCable4(String plugCable4) {
        this.plugCable4 = plugCable4;
    }

    public String getPlugCable5() {
        return plugCable5;
    }

    public void setPlugCable5(String plugCable5) {
        this.plugCable5 = plugCable5;
    }

    public String getPlugCable6() {
        return plugCable6;
    }

    public void setPlugCable6(String plugCable6) {
        this.plugCable6 = plugCable6;
    }

    public String getPlugCable7() {
        return plugCable7;
    }

    public void setPlugCable7(String plugCable7) {
        this.plugCable7 = plugCable7;
    }

    public String getPlugCable8() {
        return plugCable8;
    }

    public void setPlugCable8(String plugCable8) {
        this.plugCable8 = plugCable8;
    }

    public String getPlugCable9() {
        return plugCable9;
    }

    public void setPlugCable9(String plugCable9) {
        this.plugCable9 = plugCable9;
    }

    public String getPlugCable10() {
        return plugCable10;
    }

    public void setPlugCable10(String plugCable10) {
        this.plugCable10 = plugCable10;
    }

    public void updatePlugBoard(char letter) {

        switch (letter) {
            case 'A':
                aCheckBox.setSelected(true);
                break;
            case 'B':
                bCheckBox.setSelected(true);
                break;
            case 'C':
                cCheckBox.setSelected(true);
                break;
            case 'D':
                dCheckBox.setSelected(true);
                break;
            case 'E':
                eCheckBox.setSelected(true);
                break;
            case 'F':
                fCheckBox.setSelected(true);
                break;
            case 'G':
                gCheckBox.setSelected(true);
                break;
            case 'H':
                hCheckBox.setSelected(true);
                break;
            case 'I':
                iCheckBox.setSelected(true);
                break;
            case 'J':
                jCheckBox.setSelected(true);
                break;
            case 'K':
                kCheckBox.setSelected(true);
                break;
            case 'L':
                lCheckBox.setSelected(true);
                break;
            case 'M':
                mCheckBox.setSelected(true);
                break;
            case 'N':
                nCheckBox.setSelected(true);
                break;
            case 'O':
                oCheckBox.setSelected(true);
                break;
            case 'P':
                pCheckBox.setSelected(true);
                break;
            case 'Q':
                qCheckBox.setSelected(true);
                break;
            case 'R':
                rCheckBox.setSelected(true);
                break;
            case 'S':
                sCheckBox.setSelected(true);
                break;
            case 'T':
                tCheckBox.setSelected(true);
                break;
            case 'U':
                uCheckBox.setSelected(true);
                break;
            case 'V':
                vCheckBox.setSelected(true);
                break;
            case 'W':
                wCheckBox.setSelected(true);
                break;
            case 'X':
                xCheckBox.setSelected(true);
                break;
            case 'Y':
                yCheckBox.setSelected(true);
                break;
            case 'Z':
                zCheckBox.setSelected(true);
                break;
        }
    }

    public void resetPlugConfiguration() {
        // Enable all plug cable buttons and reset tooltips to blank
        btnPlugCable1.setEnabled(true);
        btnPlugCable2.setEnabled(true);
        btnPlugCable3.setEnabled(true);
        btnPlugCable4.setEnabled(true);
        btnPlugCable5.setEnabled(true);
        btnPlugCable6.setEnabled(true);
        btnPlugCable7.setEnabled(true);
        btnPlugCable8.setEnabled(true);
        btnPlugCable9.setEnabled(true);
        btnPlugCable10.setEnabled(true);
        btnPlugCable1.setToolTipText(PLUG_SYMBOL);
        btnPlugCable2.setToolTipText(PLUG_SYMBOL);
        btnPlugCable3.setToolTipText(PLUG_SYMBOL);
        btnPlugCable4.setToolTipText(PLUG_SYMBOL);
        btnPlugCable5.setToolTipText(PLUG_SYMBOL);
        btnPlugCable6.setToolTipText(PLUG_SYMBOL);
        btnPlugCable7.setToolTipText(PLUG_SYMBOL);
        btnPlugCable8.setToolTipText(PLUG_SYMBOL);
        btnPlugCable9.setToolTipText(PLUG_SYMBOL);
        btnPlugCable10.setToolTipText(PLUG_SYMBOL);
        // Reset plugboard back to default
        core.resetPlugBoard();
        // Reset plug cables to default
        setPlugCable1(PLUG_SYMBOL);
        setPlugCable2(PLUG_SYMBOL);
        setPlugCable3(PLUG_SYMBOL);
        setPlugCable4(PLUG_SYMBOL);
        setPlugCable5(PLUG_SYMBOL);
        setPlugCable6(PLUG_SYMBOL);
        setPlugCable7(PLUG_SYMBOL);
        setPlugCable8(PLUG_SYMBOL);
        setPlugCable9(PLUG_SYMBOL);
        setPlugCable10(PLUG_SYMBOL);
        // Reset all UX plugboard back to default
        aCheckBox.setSelected(false);
        bCheckBox.setSelected(false);
        cCheckBox.setSelected(false);
        dCheckBox.setSelected(false);
        eCheckBox.setSelected(false);
        fCheckBox.setSelected(false);
        gCheckBox.setSelected(false);
        hCheckBox.setSelected(false);
        iCheckBox.setSelected(false);
        jCheckBox.setSelected(false);
        kCheckBox.setSelected(false);
        lCheckBox.setSelected(false);
        mCheckBox.setSelected(false);
        nCheckBox.setSelected(false);
        oCheckBox.setSelected(false);
        pCheckBox.setSelected(false);
        qCheckBox.setSelected(false);
        rCheckBox.setSelected(false);
        sCheckBox.setSelected(false);
        tCheckBox.setSelected(false);
        uCheckBox.setSelected(false);
        vCheckBox.setSelected(false);
        wCheckBox.setSelected(false);
        xCheckBox.setSelected(false);
        yCheckBox.setSelected(false);
        zCheckBox.setSelected(false);
        // Reset UX rotors back to default
        cboRotor1.setSelectedItem(Integer.toString(1));
        cboRotor2.setSelectedItem(Integer.toString(1));
        cboRotor3.setSelectedItem(Integer.toString(1));
        // Output configuration
        System.out.println(core);
    }

    // Dialog input for plug cable configuration starts here
    public int promptPlugCableChange(String plugCableConfig) {
        return JOptionPane.showConfirmDialog(null,
                "Currently set to: " + plugCableConfig + "\n" + "Do you want to change it?",
                "Current plug cable configuration",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }

    public String inputPlugCableConfig() {
        String input = "";
        try {
            String inputOrigin = JOptionPane.showInputDialog("Enter Origin on plug board (A-Z)");
            input = inputOrigin.charAt(0) + PLUG_SYMBOL;
            String inputDestination = JOptionPane.showInputDialog("Enter Destination on plug board (A-Z)");
            input = input + inputDestination.charAt(0);
        } catch (NullPointerException ex) {
            // User clicked on cancel, set it back to default setting
            return PLUG_SYMBOL;
        }
        return input.toUpperCase();
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());
        panelRotors = new JPanel();
        panelRotors.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelMain.add(panelRotors, gbc);
        panelRotors.setBorder(BorderFactory.createTitledBorder(null, "Rotor Settings", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        cboRotor3 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("1");
        defaultComboBoxModel1.addElement("2");
        defaultComboBoxModel1.addElement("3");
        defaultComboBoxModel1.addElement("4");
        defaultComboBoxModel1.addElement("5");
        defaultComboBoxModel1.addElement("6");
        defaultComboBoxModel1.addElement("7");
        defaultComboBoxModel1.addElement("8");
        defaultComboBoxModel1.addElement("9");
        defaultComboBoxModel1.addElement("10");
        defaultComboBoxModel1.addElement("11");
        defaultComboBoxModel1.addElement("12");
        defaultComboBoxModel1.addElement("13");
        defaultComboBoxModel1.addElement("14");
        defaultComboBoxModel1.addElement("15");
        defaultComboBoxModel1.addElement("16");
        defaultComboBoxModel1.addElement("17");
        defaultComboBoxModel1.addElement("18");
        defaultComboBoxModel1.addElement("19");
        defaultComboBoxModel1.addElement("20");
        defaultComboBoxModel1.addElement("21");
        defaultComboBoxModel1.addElement("22");
        defaultComboBoxModel1.addElement("23");
        defaultComboBoxModel1.addElement("24");
        defaultComboBoxModel1.addElement("25");
        defaultComboBoxModel1.addElement("26");
        cboRotor3.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(cboRotor3, gbc);
        cboRotor2 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("1");
        defaultComboBoxModel2.addElement("2");
        defaultComboBoxModel2.addElement("3");
        defaultComboBoxModel2.addElement("4");
        defaultComboBoxModel2.addElement("5");
        defaultComboBoxModel2.addElement("6");
        defaultComboBoxModel2.addElement("7");
        defaultComboBoxModel2.addElement("8");
        defaultComboBoxModel2.addElement("9");
        defaultComboBoxModel2.addElement("10");
        defaultComboBoxModel2.addElement("11");
        defaultComboBoxModel2.addElement("12");
        defaultComboBoxModel2.addElement("13");
        defaultComboBoxModel2.addElement("14");
        defaultComboBoxModel2.addElement("15");
        defaultComboBoxModel2.addElement("16");
        defaultComboBoxModel2.addElement("17");
        defaultComboBoxModel2.addElement("18");
        defaultComboBoxModel2.addElement("19");
        defaultComboBoxModel2.addElement("20");
        defaultComboBoxModel2.addElement("21");
        defaultComboBoxModel2.addElement("22");
        defaultComboBoxModel2.addElement("23");
        defaultComboBoxModel2.addElement("24");
        defaultComboBoxModel2.addElement("25");
        defaultComboBoxModel2.addElement("26");
        cboRotor2.setModel(defaultComboBoxModel2);
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(cboRotor2, gbc);
        cboRotor1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("1");
        defaultComboBoxModel3.addElement("2");
        defaultComboBoxModel3.addElement("3");
        defaultComboBoxModel3.addElement("4");
        defaultComboBoxModel3.addElement("5");
        defaultComboBoxModel3.addElement("6");
        defaultComboBoxModel3.addElement("7");
        defaultComboBoxModel3.addElement("8");
        defaultComboBoxModel3.addElement("9");
        defaultComboBoxModel3.addElement("10");
        defaultComboBoxModel3.addElement("11");
        defaultComboBoxModel3.addElement("12");
        defaultComboBoxModel3.addElement("13");
        defaultComboBoxModel3.addElement("14");
        defaultComboBoxModel3.addElement("15");
        defaultComboBoxModel3.addElement("16");
        defaultComboBoxModel3.addElement("17");
        defaultComboBoxModel3.addElement("18");
        defaultComboBoxModel3.addElement("19");
        defaultComboBoxModel3.addElement("20");
        defaultComboBoxModel3.addElement("21");
        defaultComboBoxModel3.addElement("22");
        defaultComboBoxModel3.addElement("23");
        defaultComboBoxModel3.addElement("24");
        defaultComboBoxModel3.addElement("25");
        defaultComboBoxModel3.addElement("26");
        cboRotor1.setModel(defaultComboBoxModel3);
        gbc = new GridBagConstraints();
        gbc.gridx = 11;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(cboRotor1, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelRotors.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelRotors.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelRotors.add(label3, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 12;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRotors.add(spacer7, gbc);
        panelMessageIO = new JPanel();
        panelMessageIO.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelMain.add(panelMessageIO, gbc);
        panelMessageIO.setBorder(BorderFactory.createTitledBorder(null, "Message Input/Output", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label4 = new JLabel();
        label4.setText("Result");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelMessageIO.add(label4, gbc);
        txtResult = new JTextField();
        txtResult.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMessageIO.add(txtResult, gbc);
        txtInput = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMessageIO.add(txtInput, gbc);
        final JLabel label5 = new JLabel();
        label5.setHorizontalAlignment(0);
        label5.setHorizontalTextPosition(11);
        label5.setText("Enter Message");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelMessageIO.add(label5, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 3;
        panelMessageIO.add(spacer8, gbc);
        panelPlugBoard = new JPanel();
        panelPlugBoard.setLayout(new GridBagLayout());
        panelPlugBoard.setEnabled(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelMain.add(panelPlugBoard, gbc);
        panelPlugBoard.setBorder(BorderFactory.createTitledBorder(null, "Plug Board Settings", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        aCheckBox = new JCheckBox();
        aCheckBox.setEnabled(true);
        Font aCheckBoxFont = this.$$$getFont$$$(null, -1, -1, aCheckBox.getFont());
        if (aCheckBoxFont != null) aCheckBox.setFont(aCheckBoxFont);
        aCheckBox.setSelected(false);
        aCheckBox.setText("A");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(aCheckBox, gbc);
        cCheckBox = new JCheckBox();
        cCheckBox.setEnabled(true);
        cCheckBox.setText("C");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(cCheckBox, gbc);
        bCheckBox = new JCheckBox();
        bCheckBox.setEnabled(true);
        bCheckBox.setText("B");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(bCheckBox, gbc);
        dCheckBox = new JCheckBox();
        dCheckBox.setEnabled(true);
        dCheckBox.setText("D");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(dCheckBox, gbc);
        eCheckBox = new JCheckBox();
        eCheckBox.setEnabled(true);
        eCheckBox.setText("E");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(eCheckBox, gbc);
        fCheckBox = new JCheckBox();
        fCheckBox.setText("F");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(fCheckBox, gbc);
        gCheckBox = new JCheckBox();
        gCheckBox.setText("G");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(gCheckBox, gbc);
        hCheckBox = new JCheckBox();
        hCheckBox.setText("H");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(hCheckBox, gbc);
        iCheckBox = new JCheckBox();
        iCheckBox.setText("I");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(iCheckBox, gbc);
        jCheckBox = new JCheckBox();
        jCheckBox.setText("J");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(jCheckBox, gbc);
        kCheckBox = new JCheckBox();
        kCheckBox.setText("K");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(kCheckBox, gbc);
        lCheckBox = new JCheckBox();
        lCheckBox.setText("L");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(lCheckBox, gbc);
        mCheckBox = new JCheckBox();
        mCheckBox.setText("M");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(mCheckBox, gbc);
        nCheckBox = new JCheckBox();
        nCheckBox.setText("N");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(nCheckBox, gbc);
        oCheckBox = new JCheckBox();
        oCheckBox.setText("O");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(oCheckBox, gbc);
        pCheckBox = new JCheckBox();
        pCheckBox.setText("P");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(pCheckBox, gbc);
        qCheckBox = new JCheckBox();
        qCheckBox.setText("Q");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(qCheckBox, gbc);
        rCheckBox = new JCheckBox();
        rCheckBox.setText("R");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(rCheckBox, gbc);
        sCheckBox = new JCheckBox();
        sCheckBox.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(sCheckBox, gbc);
        tCheckBox = new JCheckBox();
        tCheckBox.setText("T");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(tCheckBox, gbc);
        uCheckBox = new JCheckBox();
        uCheckBox.setText("U");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(uCheckBox, gbc);
        vCheckBox = new JCheckBox();
        vCheckBox.setText("V");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(vCheckBox, gbc);
        wCheckBox = new JCheckBox();
        wCheckBox.setText("W");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(wCheckBox, gbc);
        xCheckBox = new JCheckBox();
        xCheckBox.setText("X");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(xCheckBox, gbc);
        yCheckBox = new JCheckBox();
        yCheckBox.setText("Y");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(yCheckBox, gbc);
        zCheckBox = new JCheckBox();
        zCheckBox.setText("Z");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPlugBoard.add(zCheckBox, gbc);
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelMain.add(panelButtons, gbc);
        btnEncode = new JButton();
        btnEncode.setText("Encode Message");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelButtons.add(btnEncode, gbc);
        btnDecode = new JButton();
        btnDecode.setText("Decode Message");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelButtons.add(btnDecode, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        panelButtons.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        panelButtons.add(spacer10, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelButtons.add(spacer11, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panelButtons.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 5;
        panelMain.add(spacer13, gbc);
        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 5;
        panelMain.add(spacer14, gbc);
        final JPanel spacer15 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 5;
        panelMain.add(spacer15, gbc);
        final JPanel spacer16 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        panelMain.add(spacer16, gbc);
        final JPanel spacer17 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        panelMain.add(spacer17, gbc);
        final JPanel spacer18 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 5;
        panelMain.add(spacer18, gbc);
        panelPlugCable = new JPanel();
        panelPlugCable.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        panelMain.add(panelPlugCable, gbc);
        panelPlugCable.setBorder(BorderFactory.createTitledBorder(null, "Plug Cable Configuration", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        btnPlugCable2 = new JButton();
        btnPlugCable2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable2, gbc);
        btnPlugCable3 = new JButton();
        btnPlugCable3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable3, gbc);
        btnPlugCable4 = new JButton();
        btnPlugCable4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable4, gbc);
        btnPlugCable5 = new JButton();
        btnPlugCable5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable5, gbc);
        btnPlugCable6 = new JButton();
        btnPlugCable6.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable6, gbc);
        btnPlugCable7 = new JButton();
        btnPlugCable7.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable7, gbc);
        btnPlugCable8 = new JButton();
        btnPlugCable8.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable8, gbc);
        btnPlugCable9 = new JButton();
        btnPlugCable9.setText("9");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable9, gbc);
        btnPlugCable10 = new JButton();
        btnPlugCable10.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable10, gbc);
        btnPlugCable1 = new JButton();
        btnPlugCable1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlugCable.add(btnPlugCable1, gbc);
        final JPanel spacer19 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        panelPlugCable.add(spacer19, gbc);
        final JPanel spacer20 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        panelPlugCable.add(spacer20, gbc);
        btnResetConfig = new JButton();
        btnResetConfig.setHorizontalAlignment(0);
        btnResetConfig.setHorizontalTextPosition(11);
        btnResetConfig.setText("Reset");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panelPlugCable.add(btnResetConfig, gbc);
        final JPanel spacer21 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        panelMain.add(spacer21, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
