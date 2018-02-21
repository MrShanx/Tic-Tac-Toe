/*
 * Decompiled with CFR 0_123.
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window
extends JFrame {
    JFrame frame = new JFrame("TicTacToe!");
    JButton restart;
    JLabel lab;
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    boolean winner = false;
    JButton[] buttons = new JButton[9];
    int turn = 0;
    JOptionPane op;
    JButton[] butts = new JButton[9];

    public Window() {
        this.frame.setSize(450, 333);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
    }

    private void initialize() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, 1));
        JPanel labPanel = new JPanel();
        this.lab = new JLabel("You first!");
        labPanel.setLayout(new BoxLayout(labPanel, 2));
        labPanel.add(this.lab);
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        this.buttons[0] = this.one = new JButton("");
        this.buttons[1] = this.two = new JButton("");
        this.buttons[2] = this.three = new JButton("");
        this.buttons[3] = this.four = new JButton("");
        this.buttons[4] = this.five = new JButton("");
        this.buttons[5] = this.six = new JButton("");
        this.buttons[6] = this.seven = new JButton("");
        this.buttons[7] = this.eight = new JButton("");
        this.buttons[8] = this.nine = new JButton("");
        boardPanel.add(this.one);
        boardPanel.add(this.two);
        boardPanel.add(this.three);
        boardPanel.add(this.four);
        boardPanel.add(this.five);
        boardPanel.add(this.six);
        boardPanel.add(this.seven);
        boardPanel.add(this.eight);
        boardPanel.add(this.nine);
        JPanel buttonPane = new JPanel();
        this.restart = new JButton("restart");
        buttonPane.setLayout(new BoxLayout(buttonPane, 2));
        buttonPane.add(this.restart);
        mainPanel.add(labPanel);
        mainPanel.add(boardPanel);
        mainPanel.add(buttonPane);
        this.frame.add(mainPanel);
        this.restart.addActionListener(new myActionListener());
        this.one.addActionListener(new myActionListener());
        this.two.addActionListener(new myActionListener());
        this.three.addActionListener(new myActionListener());
        this.four.addActionListener(new myActionListener());
        this.five.addActionListener(new myActionListener());
        this.six.addActionListener(new myActionListener());
        this.seven.addActionListener(new myActionListener());
        this.eight.addActionListener(new myActionListener());
        this.nine.addActionListener(new myActionListener());
        this.butts[0] = this.one;
        this.butts[1] = this.two;
        this.butts[2] = this.three;
        this.butts[3] = this.four;
        this.butts[4] = this.five;
        this.butts[5] = this.six;
        this.butts[6] = this.seven;
        this.butts[7] = this.eight;
        this.butts[8] = this.nine;
        this.frame.setVisible(true);
    }

    private void compTurn() {
        boolean result = true;
        for (int i = 0; i < 9; ++i) {
            if (!this.buttons[i].isEnabled()) continue;
            result = false;
        }
        if (result) {
            this.stop(3);
        } else {
            this.AiTurn();
        }
    }

    private void AiTurn() {
        for (int a = 1; a <= 9; ++a) {
            if (!this.checkAvail(a) || !this.checkWinMove(a)) continue;
            this.stop(2);
            return;
        }
        for (int b = 1; b <= 9; ++b) {
            if (!this.checkAvail(b) || !this.checkBlockMove(b)) continue;
            return;
        }
        int num = 0;
        while (!this.checkAvail(num = this.getRanNum())) {
        }
        this.checkJustMove(num);
    }

    private int getRanNum() {
        int c = (int)(Math.random() * 9.0 + 1.0);
        if (this.checkAvail(c)) {
            return c;
        }
        this.getRanNum();
        return c;
    }

    private boolean checkAvail(int rMove) {
        if (this.butts[rMove - 1].isEnabled()) {
            return true;
        }
        return false;
    }

    private boolean checkWinMove(int rMove) {
        if (rMove == 1) {
            if (this.two.getText().equalsIgnoreCase("O") && this.three.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.two.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.one.setEnabled(false);
                this.one.setText("O");
                return true;
            }
            if (this.four.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
                this.four.setBackground(Color.red);
                this.seven.setBackground(Color.red);
                this.one.setEnabled(false);
                this.one.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("O") && this.nine.getText().equalsIgnoreCase("O")) {
                this.five.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.one.setBackground(Color.red);
                this.one.setEnabled(false);
                this.one.setText("O");
                return true;
            }
        }
        if (rMove == 2) {
            if (this.one.getText().equalsIgnoreCase("O") && this.three.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.two.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.two.setEnabled(false);
                this.two.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("O") && this.eight.getText().equalsIgnoreCase("O")) {
                this.five.setBackground(Color.red);
                this.two.setBackground(Color.red);
                this.eight.setBackground(Color.red);
                this.two.setEnabled(false);
                this.two.setText("O");
                return true;
            }
        }
        if (rMove == 3) {
            if (this.two.getText().equalsIgnoreCase("O") && this.one.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.two.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.three.setEnabled(false);
                this.three.setText("O");
                return true;
            }
            if (this.six.getText().equalsIgnoreCase("O") && this.nine.getText().equalsIgnoreCase("O")) {
                this.six.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.three.setEnabled(false);
                this.three.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
                this.five.setBackground(Color.red);
                this.seven.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.three.setEnabled(false);
                this.three.setText("O");
                return true;
            }
        }
        if (rMove == 4) {
            if (this.one.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.seven.setBackground(Color.red);
                this.four.setBackground(Color.red);
                this.four.setEnabled(false);
                this.four.setText("O");
                return true;
            }
            if (this.six.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O")) {
                this.four.setBackground(Color.red);
                this.six.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.four.setEnabled(false);
                this.four.setText("O");
                return true;
            }
        }
        if (rMove == 5) {
            if (this.nine.getText().equalsIgnoreCase("O") && this.one.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
            if (this.two.getText().equalsIgnoreCase("O") && this.eight.getText().equalsIgnoreCase("O")) {
                this.eight.setBackground(Color.red);
                this.two.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
            if (this.three.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
                this.five.setBackground(Color.red);
                this.seven.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
            if (this.four.getText().equalsIgnoreCase("O") && this.six.getText().equalsIgnoreCase("O")) {
                this.six.setBackground(Color.red);
                this.four.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
        }
        if (rMove == 6) {
            if (this.three.getText().equalsIgnoreCase("O") && this.nine.getText().equalsIgnoreCase("O")) {
                this.nine.setBackground(Color.red);
                this.six.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.six.setEnabled(false);
                this.six.setText("O");
                return true;
            }
            if (this.four.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O")) {
                this.five.setBackground(Color.red);
                this.four.setBackground(Color.red);
                this.six.setBackground(Color.red);
                this.six.setEnabled(false);
                this.six.setText("O");
                return true;
            }
        }
        if (rMove == 7) {
            if (this.four.getText().equalsIgnoreCase("O") && this.one.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.seven.setBackground(Color.red);
                this.four.setBackground(Color.red);
                this.seven.setEnabled(false);
                this.seven.setText("O");
                return true;
            }
            if (this.nine.getText().equalsIgnoreCase("O") && this.eight.getText().equalsIgnoreCase("O")) {
                this.seven.setBackground(Color.red);
                this.eight.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.seven.setEnabled(false);
                this.seven.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("O") && this.three.getText().equalsIgnoreCase("O")) {
                this.seven.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.seven.setEnabled(false);
                this.seven.setText("O");
                return true;
            }
        }
        if (rMove == 8) {
            if (this.nine.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
                this.nine.setBackground(Color.red);
                this.seven.setBackground(Color.red);
                this.eight.setBackground(Color.red);
                this.eight.setEnabled(false);
                this.eight.setText("O");
                return true;
            }
            if (this.two.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O")) {
                this.eight.setBackground(Color.red);
                this.two.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.eight.setEnabled(false);
                this.eight.setText("O");
                return true;
            }
        }
        if (rMove == 9) {
            if (this.three.getText().equalsIgnoreCase("O") && this.six.getText().equalsIgnoreCase("O")) {
                this.six.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.three.setBackground(Color.red);
                this.nine.setEnabled(false);
                this.nine.setText("O");
                return true;
            }
            if (this.one.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O")) {
                this.one.setBackground(Color.red);
                this.five.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.nine.setEnabled(false);
                this.nine.setText("O");
                return true;
            }
            if (this.eight.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
                this.seven.setBackground(Color.red);
                this.eight.setBackground(Color.red);
                this.nine.setBackground(Color.red);
                this.nine.setEnabled(false);
                this.nine.setText("O");
                return true;
            }
        }
        return false;
    }

    private boolean checkBlockMove(int rMove) {
        if (rMove == 1) {
            if (this.two.getText().equalsIgnoreCase("X") && this.three.getText().equalsIgnoreCase("X") && !this.two.isEnabled()) {
                this.one.setEnabled(false);
                this.one.setText("O");
                return true;
            }
            if (this.four.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X") && !this.four.isEnabled()) {
                this.one.setEnabled(false);
                this.one.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("X") && this.nine.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.one.setEnabled(false);
                this.one.setText("O");
                return true;
            }
        }
        if (rMove == 2) {
            if (this.one.getText().equalsIgnoreCase("X") && this.three.getText().equalsIgnoreCase("X") && !this.one.isEnabled()) {
                this.two.setEnabled(false);
                this.two.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("X") && this.eight.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.two.setEnabled(false);
                this.two.setText("O");
                return true;
            }
        }
        if (rMove == 3) {
            if (this.two.getText().equalsIgnoreCase("X") && this.one.getText().equalsIgnoreCase("X") && !this.two.isEnabled()) {
                this.three.setEnabled(false);
                this.three.setText("O");
                return true;
            }
            if (this.six.getText().equalsIgnoreCase("X") && this.nine.getText().equalsIgnoreCase("X") && !this.six.isEnabled()) {
                this.three.setEnabled(false);
                this.three.setText("O");
                return true;
            }
            if (this.five.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.three.setEnabled(false);
                this.three.setText("O");
                return true;
            }
        }
        if (rMove == 4) {
            if (this.one.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X") && !this.one.isEnabled()) {
                this.four.setEnabled(false);
                this.four.setText("O");
                return true;
            }
            if (this.six.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.four.setEnabled(false);
                this.four.setText("O");
                return true;
            }
        }
        if (rMove == 5) {
            if (this.nine.getText().equalsIgnoreCase("X") && this.one.getText().equalsIgnoreCase("X") && !this.one.isEnabled()) {
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
            if (this.two.getText().equalsIgnoreCase("X") && this.eight.getText().equalsIgnoreCase("X") && !this.eight.isEnabled()) {
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
            if (this.three.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X") && !this.three.isEnabled()) {
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
            if (this.four.getText().equalsIgnoreCase("X") && this.six.getText().equalsIgnoreCase("X") && !this.six.isEnabled()) {
                this.five.setEnabled(false);
                this.five.setText("O");
                return true;
            }
        }
        if (rMove == 6) {
            if (this.three.getText().equalsIgnoreCase("X") && this.nine.getText().equalsIgnoreCase("X") && !this.nine.isEnabled()) {
                this.six.setEnabled(false);
                this.six.setText("O");
                return true;
            }
            if (this.four.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.six.setEnabled(false);
                this.six.setText("O");
                return true;
            }
        }
        if (rMove == 7) {
            if (this.five.getText().equalsIgnoreCase("X") && this.three.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.seven.setEnabled(false);
                this.seven.setText("O");
                this.seven.setEnabled(false);
                this.seven.setText("O");
                return true;
            }
            if (this.nine.getText().equalsIgnoreCase("X") && this.eight.getText().equalsIgnoreCase("X") && !this.nine.isEnabled()) {
                this.seven.setEnabled(false);
                this.seven.setText("O");
                return true;
            }
            if (this.one.getText().equalsIgnoreCase("X") && this.four.getText().equalsIgnoreCase("X") && !this.four.isEnabled()) {
                this.seven.setEnabled(false);
                this.seven.setText("O");
                return true;
            }
        }
        if (rMove == 8) {
            if (this.nine.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X") && !this.nine.isEnabled()) {
                this.eight.setEnabled(false);
                this.eight.setText("O");
                return true;
            }
            if (this.two.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.eight.setEnabled(false);
                this.eight.setText("O");
                return true;
            }
        }
        if (rMove == 9) {
            if (this.three.getText().equalsIgnoreCase("X") && this.six.getText().equalsIgnoreCase("X") && !this.six.isEnabled()) {
                this.nine.setEnabled(false);
                this.nine.setText("O");
                return true;
            }
            if (this.one.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && !this.five.isEnabled()) {
                this.nine.setEnabled(false);
                this.nine.setText("O");
                return true;
            }
            if (this.eight.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X") && !this.eight.isEnabled()) {
                this.nine.setEnabled(false);
                this.nine.setText("O");
                return true;
            }
        }
        return false;
    }

    private void checkJustMove(int rMove) {
        switch (rMove) {
            case 1: {
                this.one.setEnabled(false);
                this.one.setText("O");
                break;
            }
            case 2: {
                this.two.setEnabled(false);
                this.two.setText("O");
                break;
            }
            case 3: {
                this.three.setEnabled(false);
                this.three.setText("O");
                break;
            }
            case 4: {
                this.four.setEnabled(false);
                this.four.setText("O");
                break;
            }
            case 5: {
                this.five.setEnabled(false);
                this.five.setText("O");
                break;
            }
            case 6: {
                this.six.setEnabled(false);
                this.six.setText("O");
                break;
            }
            case 7: {
                this.seven.setEnabled(false);
                this.seven.setText("O");
                break;
            }
            case 8: {
                this.eight.setEnabled(false);
                this.eight.setText("O");
                break;
            }
            case 9: {
                this.nine.setEnabled(false);
                this.nine.setText("O");
            }
        }
    }

    private void stop(int tur) {
        if (tur == 1) {
            this.op = new JOptionPane(new JLabel("YOU WIN!", 0));
            this.lab.setText("YAH!");
        } else if (tur == 2) {
            this.op = new JOptionPane(new JLabel("YOU LOSE!", 0));
            this.lab.setText("OW!");
        } else {
            this.op = new JOptionPane(new JLabel("DRAW!", 0));
            this.lab.setText("GREAT MATCH!");
        }
        JDialog dialog = this.op.createDialog("");
        dialog.setModal(true);
        dialog.setVisible(true);
    }

    private boolean checkWin() {
        if (this.one.getText().equalsIgnoreCase("X") && this.two.getText().equalsIgnoreCase("X") && this.three.getText().equalsIgnoreCase("X")) {
            this.one.setBackground(Color.green);
            this.two.setBackground(Color.green);
            this.three.setBackground(Color.green);
            return true;
        }
        if (this.one.getText().equalsIgnoreCase("O") && this.two.getText().equalsIgnoreCase("O") && this.three.getText().equalsIgnoreCase("O")) {
            this.one.setBackground(Color.red);
            this.two.setBackground(Color.red);
            this.three.setBackground(Color.red);
            return true;
        }
        if (this.one.getText().equalsIgnoreCase("X") && this.four.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X")) {
            this.one.setBackground(Color.green);
            this.four.setBackground(Color.green);
            this.seven.setBackground(Color.green);
            return true;
        }
        if (this.one.getText().equalsIgnoreCase("O") && this.four.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
            this.one.setBackground(Color.red);
            this.four.setBackground(Color.red);
            this.seven.setBackground(Color.red);
            return true;
        }
        if (this.one.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && this.nine.getText().equalsIgnoreCase("X")) {
            this.one.setBackground(Color.green);
            this.five.setBackground(Color.green);
            this.nine.setBackground(Color.green);
            return true;
        }
        if (this.one.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O") && this.nine.getText().equalsIgnoreCase("O")) {
            this.one.setBackground(Color.red);
            this.five.setBackground(Color.red);
            this.nine.setBackground(Color.red);
            return true;
        }
        if (this.two.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && this.eight.getText().equalsIgnoreCase("X")) {
            this.two.setBackground(Color.green);
            this.five.setBackground(Color.green);
            this.eight.setBackground(Color.green);
            return true;
        }
        if (this.two.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O") && this.eight.getText().equalsIgnoreCase("O")) {
            this.two.setBackground(Color.red);
            this.five.setBackground(Color.red);
            this.eight.setBackground(Color.red);
            return true;
        }
        if (this.three.getText().equalsIgnoreCase("X") && this.six.getText().equalsIgnoreCase("X") && this.nine.getText().equalsIgnoreCase("X")) {
            this.three.setBackground(Color.green);
            this.six.setBackground(Color.green);
            this.nine.setBackground(Color.green);
            return true;
        }
        if (this.three.getText().equalsIgnoreCase("O") && this.six.getText().equalsIgnoreCase("O") && this.nine.getText().equalsIgnoreCase("O")) {
            this.three.setBackground(Color.red);
            this.six.setBackground(Color.red);
            this.nine.setBackground(Color.red);
            return true;
        }
        if (this.three.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && this.seven.getText().equalsIgnoreCase("X")) {
            this.three.setBackground(Color.green);
            this.five.setBackground(Color.green);
            this.seven.setBackground(Color.green);
            return true;
        }
        if (this.three.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O") && this.seven.getText().equalsIgnoreCase("O")) {
            this.three.setBackground(Color.red);
            this.five.setBackground(Color.red);
            this.seven.setBackground(Color.red);
            return true;
        }
        if (this.four.getText().equalsIgnoreCase("X") && this.five.getText().equalsIgnoreCase("X") && this.six.getText().equalsIgnoreCase("X")) {
            this.four.setBackground(Color.green);
            this.five.setBackground(Color.green);
            this.six.setBackground(Color.green);
            return true;
        }
        if (this.four.getText().equalsIgnoreCase("O") && this.five.getText().equalsIgnoreCase("O") && this.six.getText().equalsIgnoreCase("O")) {
            this.four.setBackground(Color.red);
            this.five.setBackground(Color.red);
            this.six.setBackground(Color.red);
            return true;
        }
        if (this.seven.getText().equalsIgnoreCase("X") && this.eight.getText().equalsIgnoreCase("X") && this.nine.getText().equalsIgnoreCase("X")) {
            this.seven.setBackground(Color.green);
            this.eight.setBackground(Color.green);
            this.nine.setBackground(Color.green);
            return true;
        }
        if (this.seven.getText().equalsIgnoreCase("O") && this.eight.getText().equalsIgnoreCase("O") && this.nine.getText().equalsIgnoreCase("O")) {
            this.seven.setBackground(Color.red);
            this.eight.setBackground(Color.red);
            this.nine.setBackground(Color.red);
            return true;
        }
        return false;
    }

    private void reset() {
        this.one.setText("");
        this.two.setText("");
        this.three.setText("");
        this.four.setText("");
        this.five.setText("");
        this.six.setText("");
        this.seven.setText("");
        this.eight.setText("");
        this.nine.setText("");
        this.one.setForeground(Color.black);
        this.two.setForeground(Color.black);
        this.three.setForeground(Color.black);
        this.four.setForeground(Color.black);
        this.five.setForeground(Color.black);
        this.six.setForeground(Color.black);
        this.seven.setForeground(Color.black);
        this.eight.setForeground(Color.black);
        this.nine.setForeground(Color.black);
        this.one.setEnabled(true);
        this.two.setEnabled(true);
        this.three.setEnabled(true);
        this.four.setEnabled(true);
        this.five.setEnabled(true);
        this.six.setEnabled(true);
        this.seven.setEnabled(true);
        this.eight.setEnabled(true);
        this.nine.setEnabled(true);
        this.one.setBackground(null);
        this.two.setBackground(null);
        this.three.setBackground(null);
        this.four.setBackground(null);
        this.five.setBackground(null);
        this.six.setBackground(null);
        this.seven.setBackground(null);
        this.eight.setBackground(null);
        this.nine.setBackground(null);
    }

    public static void main(String[] args) {
        Window game = new Window();
        game.initialize();
    }

    private class myActionListener
    implements ActionListener {
        private myActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Window.this.restart) {
                Window.this.lab.setText("New Game!");
                Window.this.reset();
            } else if (e.getSource() == Window.this.one) {
                Window.this.one.setEnabled(false);
                Window.this.one.setText("X");
                Window.this.one.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.two) {
                Window.this.two.setEnabled(false);
                Window.this.two.setText("X");
                Window.this.two.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.three) {
                Window.this.three.setEnabled(false);
                Window.this.three.setText("X");
                Window.this.three.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.four) {
                Window.this.four.setEnabled(false);
                Window.this.four.setText("X");
                Window.this.four.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.five) {
                Window.this.five.setEnabled(false);
                Window.this.five.setText("X");
                Window.this.five.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.six) {
                Window.this.six.setEnabled(false);
                Window.this.six.setText("X");
                Window.this.six.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.seven) {
                Window.this.seven.setEnabled(false);
                Window.this.seven.setText("X");
                Window.this.seven.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.eight) {
                Window.this.eight.setEnabled(false);
                Window.this.eight.setText("X");
                Window.this.eight.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            } else if (e.getSource() == Window.this.nine) {
                Window.this.nine.setEnabled(false);
                Window.this.nine.setText("X");
                Window.this.nine.setForeground(Color.RED);
                if (Window.this.checkWin()) {
                    Window.this.stop(1);
                } else {
                    Window.this.compTurn();
                }
            }
        }
    }

}