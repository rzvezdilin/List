import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.AttributedString;
import java.awt.font.TextAttribute;

class Main {
    ArrayList<JCheckBox> list = new ArrayList<JCheckBox>();
    JFrame frame;
    JPanel panel;
    JTextArea inputText;
    JButton add;
    JButton edit;
    JButton delete;
    JCheckBox check;

    public Main() {
        frame = new JFrame();
        panel = new JPanel();
        inputText = new JTextArea();
        add = new JButton("Добавить");
        edit = new JButton("Редактировать");
        delete = new JButton("Удалить");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBounds(5,5,390,290);
        panel.setBackground(Color.gray);

        inputText = createInput();
        add = createAddButton();
        add.addActionListener(new AddButtonListener());

        edit = createEditButton();
        edit.addActionListener(new EditButtonListener());

        delete = createDeleteButton();
        delete.addActionListener(new DeleteButtonListener());
        
        // JScrollPane scroller = new JScrollPane(panel);
        // scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // scroller.setBounds(0,0, 400, 300);
        // scroller.getViewport().setBackground(Color.red);
        // scroller.getViewport().add(panel);

        // panel.add(scroller);
        frame.add(inputText);
        frame.add(add);
        frame.add(edit);
        frame.add(delete);


        frame.add(panel);
        frame.setSize(400, 440);
        frame.setVisible(true);
    }

    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = inputText.getText();

            if(!input.isBlank()) {
                check = new JCheckBox(input);
                list.add(check);
                panel.add(check);
            } else {
                System.out.println("Введите текст...");
            }
            inputText.setText("");
        }
    }

    class  EditButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i < list.size(); i++) {
                if(list.get(i).isSelected()) {
                    String input = inputText.getText();
                    check = list.get(i);
                    if(!input.isBlank()) {
                        check.setText(input);
                        list.get(i).setSelected(false);
                    } else {
                        System.out.println("Введите текст для замены!");
                    }
                }
            }
            inputText.setText("");
        }
    }

    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for(int i=0; i < list.size(); i++) {
                if(list.get(i).isSelected()) {
                    list.get(i).setVisible(false);
                    list.remove(i);
                }
            }
        }
    }

    public JTextArea createInput() {
        inputText.setBounds(5,305, 390, 50);
        return inputText;
    }

    public JButton createAddButton() {
        add.setBounds(10, 360, 120, 30);
        return add;
    }

    public JButton createEditButton() {
        edit.setBounds(140, 360, 120, 30);
        return edit;
    }

    public JButton createDeleteButton() {
        delete.setBounds(270, 360, 120, 30);
        return delete;
    }
}