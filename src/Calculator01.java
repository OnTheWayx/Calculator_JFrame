import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator01 extends JFrame {
    private JTextArea text;
    private JRadioButton computeH, computeD, computeB;  //切换进制按钮
    private ButtonGroup compute;
    private JButton numberA, numberB, numberC, numberD, numberE, numberF,
            number0, number1, number2, number3, number4, number5, number6, number7, number8, number9,   //数字按钮
            clear, revoke, sub, add, is, ride, divide, remainder,  //功能按钮
            null1, null2, null3, null4, null5, null6;  //暂时无用按钮
    private JPanel PanelNorth, PanelCenter, PanelSouth;
    private StringBuffer cb1 = new StringBuffer();
    private StringBuffer cb2 = new StringBuffer();
    private int operateNumber = 0; //辅助操作数，标志要进行什么操作  0为原始值，1为加，2为减，3为乘，4为除, 5为求余等

    private Calculator01() {
        super("程序员计算器");
        text = new JTextArea(1, 35);
        text.setText("");
        computeH = new JRadioButton("HEX", true);
        computeD = new JRadioButton("DEC");
        computeB = new JRadioButton("BIN");
        compute = new ButtonGroup();
        compute.add(computeB);
        compute.add(computeH);
        compute.add(computeD);
        //数字按钮逐一实例化
        number0 = new JButton("0");
        number1 = new JButton("1");
        number2 = new JButton("2");
        number3 = new JButton("3");
        number4 = new JButton("4");
        number5 = new JButton("5");
        number6 = new JButton("6");
        number7 = new JButton("7");
        number8 = new JButton("8");
        number9 = new JButton("9");
        numberA = new JButton("A");
        numberB = new JButton("B");
        numberC = new JButton("C");
        numberD = new JButton("D");
        numberE = new JButton("E");
        numberF = new JButton("F");
        //功能性按钮逐一实例化
        clear = new JButton("C");
        revoke = new JButton("[x]");
        sub = new JButton("-");
        add = new JButton("+");
        is = new JButton("=");
        ride = new JButton("*");
        divide = new JButton("/");
        remainder = new JButton("%");
        null1 = new JButton("<<");
        null1.setBackground(Color.darkGray);
        null2 = new JButton(">>");
        null2.setBackground(Color.darkGray);
        null3 = new JButton("(");
        null3.setBackground(Color.darkGray);
        null4 = new JButton(")");
        null4.setBackground(Color.darkGray);
        null5 = new JButton("+/-");
        null5.setBackground(Color.darkGray);
        null6 = new JButton(".");
        null6.setBackground(Color.darkGray);
        PanelNorth = new JPanel();
        PanelCenter = new JPanel();
        PanelSouth = new JPanel();
        PanelCenter.setLayout(new GridLayout(6, 5, 5, 5));
        text.setEditable(false);   //设置文本框不可编辑
        this.setSize(400, 300);
        this.setLocation(400, 240);
        PanelNorth.add(text);
        PanelSouth.add(computeH);
        PanelSouth.add(computeD);
        PanelSouth.add(computeB);
        PanelCenter.add(numberA);
        PanelCenter.add(null1);
        PanelCenter.add(null2);
        PanelCenter.add(clear);
        PanelCenter.add(revoke);
        PanelCenter.add(numberB);
        PanelCenter.add(null3);
        PanelCenter.add(null4);
        PanelCenter.add(remainder);
        PanelCenter.add(divide);
        PanelCenter.add(numberC);
        PanelCenter.add(number7);
        PanelCenter.add(number8);
        PanelCenter.add(number9);
        PanelCenter.add(ride);
        PanelCenter.add(numberD);
        PanelCenter.add(number4);
        PanelCenter.add(number5);
        PanelCenter.add(number6);
        PanelCenter.add(sub);
        PanelCenter.add(numberE);
        PanelCenter.add(number1);
        PanelCenter.add(number2);
        PanelCenter.add(number3);
        PanelCenter.add(add);
        PanelCenter.add(numberF);
        PanelCenter.add(null5);
        PanelCenter.add(number0);
        PanelCenter.add(null6);
        PanelCenter.add(is);
        this.add(PanelNorth, BorderLayout.NORTH);
        this.add(PanelCenter, BorderLayout.CENTER);
        this.add(PanelSouth, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        computeH.addActionListener(e -> {
            cb1.delete(0, cb1.length());
            cb2.delete(0, cb2.length());
            text.setText("");
            numberA.setEnabled(true);
            numberB.setEnabled(true);
            numberC.setEnabled(true);
            numberD.setEnabled(true);
            numberE.setEnabled(true);
            numberF.setEnabled(true);
            number2.setEnabled(true);
            number3.setEnabled(true);
            number4.setEnabled(true);
            number5.setEnabled(true);
            number6.setEnabled(true);
            number7.setEnabled(true);
            number8.setEnabled(true);
            number9.setEnabled(true);
        });
        computeD.addActionListener(e -> {
            cb1.delete(0, cb1.length());
            cb2.delete(0, cb2.length());
            text.setText("");
            numberA.setEnabled(false);
            numberB.setEnabled(false);
            numberC.setEnabled(false);
            numberD.setEnabled(false);
            numberE.setEnabled(false);
            numberF.setEnabled(false);
            number2.setEnabled(true);
            number3.setEnabled(true);
            number4.setEnabled(true);
            number5.setEnabled(true);
            number6.setEnabled(true);
            number7.setEnabled(true);
            number8.setEnabled(true);
            number9.setEnabled(true);
        });
        computeB.addActionListener(e -> {
            cb1.delete(0, cb1.length());
            cb2.delete(0, cb2.length());
            text.setText("");
            number2.setEnabled(false);
            number3.setEnabled(false);
            number4.setEnabled(false);
            number5.setEnabled(false);
            number6.setEnabled(false);
            number7.setEnabled(false);
            number8.setEnabled(false);
            number9.setEnabled(false);
            numberA.setEnabled(false);
            numberB.setEnabled(false);
            numberC.setEnabled(false);
            numberD.setEnabled(false);
            numberE.setEnabled(false);
            numberF.setEnabled(false);
        });
        number0.addActionListener(new MyListener());   //数字按钮设置多事源一个监听器
        number1.addActionListener(new MyListener());
        number2.addActionListener(new MyListener());
        number3.addActionListener(new MyListener());
        number4.addActionListener(new MyListener());
        number5.addActionListener(new MyListener());
        number6.addActionListener(new MyListener());
        number7.addActionListener(new MyListener());
        number8.addActionListener(new MyListener());
        number9.addActionListener(new MyListener());
        numberA.addActionListener(new MyListener());
        numberB.addActionListener(new MyListener());
        numberC.addActionListener(new MyListener());
        numberD.addActionListener(new MyListener());
        numberE.addActionListener(new MyListener());
        numberF.addActionListener(new MyListener());

        //功能性按钮逐个设置功能
        clear.addActionListener(e -> {
            cb1.delete(0, cb1.length());
            cb2.delete(0, cb2.length());
            text.setText("");
        });
        revoke.addActionListener(e -> {
            try {
                cb1.delete(cb1.length() - 1, cb1.length());
                text.setText(cb1.toString());
            } catch (Exception ex) {
            }
        });
        add.addActionListener(e -> {
            if (text.getText().equals("")) {

            } else {
                text.setText("");
                cb2.append(cb1);
                cb1.delete(0, cb1.length());
                operateNumber = 1;
            }
        });
        sub.addActionListener(e -> {
            if (text.getText().equals("")){

            }else{
                text.setText("");
                cb2.append(cb1);         //cb1添加到cb2中，cb1为重新输入的数，所以cb2为被减数，cb1为减数
                cb1.delete(0, cb1.length());
                operateNumber = 2;
            }
        });
        ride.addActionListener(e -> {
            if (text.getText().equals("")){

            }else{
                text.setText("");
                cb2.append(cb1);
                cb1.delete(0, cb1.length());
                operateNumber = 3;
            }
        });
        divide.addActionListener(e -> {
            if (text.getText().equals("")){

            }else{
                text.setText("");
                cb2.append(cb1);
                cb1.delete(0, cb1.length());
                operateNumber = 4;
            }
        });
        remainder.addActionListener(e -> {
            if (text.getText().equals("")){

            }else{
                text.setText("");
                cb2.append(cb1);
                cb1.delete(0, cb1.length());
                operateNumber = 5;
            }
        });
        is.addActionListener(e -> {
            if (operateNumber == 1) {   //判定进行的操作是否是加操作
                if (computeH.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 16);
                        long L2 = Long.parseLong(cb2.toString(), 16);
                        long L3 = L1 + L2;
                        text.setText(Long.toString(L3, 16));
                    }
                }
                if (computeD.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString());
                        long L2 = Long.parseLong(cb2.toString());
                        long L3 = L1 + L2;
                        text.setText(Long.toString(L3));
                    }
                }
                if (computeB.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 2);
                        long L2 = Long.parseLong(cb2.toString(), 2);
                        long L3 = L1 + L2;
                        text.setText(Long.toString(L3, 2));
                    }
                }
            }
            if (operateNumber == 2){  //判断进行的操作是否是减操作
                if (computeH.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 16);
                        long L2 = Long.parseLong(cb2.toString(), 16);
                        long L3 = L2 - L1;
                        text.setText(Long.toString(L3, 16));
                    }
                }
                if (computeD.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString());
                        long L2 = Long.parseLong(cb2.toString());
                        long L3 = L2 - L1;
                        text.setText(Long.toString(L3));
                    }
                }
                if (computeB.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 2);
                        long L2 = Long.parseLong(cb2.toString(), 2);
                        long L3 = L2 - L1;
                        text.setText(Long.toString(L3, 2));
                    }
                }
            }
            if (operateNumber == 3){
                if (computeH.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 16);
                        long L2 = Long.parseLong(cb2.toString(), 16);
                        long L3 = L2 * L1;
                        text.setText(Long.toString(L3, 16));
                    }
                }
                if (computeD.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString());
                        long L2 = Long.parseLong(cb2.toString());
                        long L3 = L2 * L1;
                        text.setText(Long.toString(L3));
                    }
                }
                if (computeB.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 2);
                        long L2 = Long.parseLong(cb2.toString(), 2);
                        long L3 = L2 * L1;
                        text.setText(Long.toString(L3, 2));
                    }
                }
            }
            if (operateNumber == 4){
                if (computeH.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 16);
                        long L2 = Long.parseLong(cb2.toString(), 16);
                        long L3 = L2 / L1;
                        text.setText(Long.toString(L3, 16));
                    }
                }
                if (computeD.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString());
                        long L2 = Long.parseLong(cb2.toString());
                        long L3 = L2 / L1;
                        text.setText(Long.toString(L3));
                    }
                }
                if (computeB.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 2);
                        long L2 = Long.parseLong(cb2.toString(), 2);
                        long L3 = L2 / L1;
                        text.setText(Long.toString(L3, 2));
                    }
                }
            }
            if (operateNumber == 5){
                if (computeH.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 16);
                        long L2 = Long.parseLong(cb2.toString(), 16);
                        long L3 = L2 % L1;
                        text.setText(Long.toString(L3, 16));
                    }
                }
                if (computeD.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString());
                        long L2 = Long.parseLong(cb2.toString());
                        long L3 = L2 % L1;
                        text.setText(Long.toString(L3));
                    }
                }
                if (computeB.isSelected()) {
                    if (text.getText().equals("")) {

                    } else {
                        long L1 = Long.parseLong(cb1.toString(), 2);
                        long L2 = Long.parseLong(cb2.toString(), 2);
                        long L3 = L2 % L1;
                        text.setText(Long.toString(L3, 2));
                    }
                }
            }
            operateNumber = 0;
        });
    }

    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == number0) {
                if (text.getText().equals("")) {
                } else {
                    cb1.append("0");
                    text.setText(cb1.toString());
                }
            }
            if (e.getSource() == number1) {
                cb1.append("1");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number2) {
                cb1.append("2");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number3) {
                cb1.append("3");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number4) {
                cb1.append("4");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number5) {
                cb1.append("5");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number6) {
                cb1.append("6");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number7) {
                cb1.append("7");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number8) {
                cb1.append("8");
                text.setText(cb1.toString());
            }
            if (e.getSource() == number9) {
                cb1.append("9");
                text.setText(cb1.toString());
            }
            if (e.getSource() == numberA) {
                cb1.append("A");
                text.setText(cb1.toString());
            }
            if (e.getSource() == numberB) {
                cb1.append("B");
                text.setText(cb1.toString());
            }
            if (e.getSource() == numberC) {
                cb1.append("C");
                text.setText(cb1.toString());
            }
            if (e.getSource() == numberD) {
                cb1.append("D");
                text.setText(cb1.toString());
            }
            if (e.getSource() == numberE) {
                cb1.append("E");
                text.setText(cb1.toString());
            }
            if (e.getSource() == numberF) {
                cb1.append("F");
                text.setText(cb1.toString());
            }
        }
    }

    public static void main(String[] args) {
        new Calculator01();
    }
}
