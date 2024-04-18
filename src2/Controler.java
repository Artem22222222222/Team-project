package src2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements Icontroler, ActionListener {
    Imodel m;
    IUI ui;
    UI ui2 = new UI();
    //потрібні для роботи об'єкти

    public Controler() {
        this.ui = new UI2();
    }

    public void setM(Imodel m) {
        this.m = m;
    }

    public void actionPerformed(ActionEvent e) {//переніс основний ActionListener з UI
        JButton b = (JButton) e.getSource();
        ui2.setSelectedIndex(ui2.getContactList().getSelectedIndex());
        switch (b.getText()) {
            case "+":
                ui.add();
                break;

            case "Delete":
                m.delete();
                break;

            case "Edit":
                ui.edit();
                break;
        }
    }

    //функції виликаються з UI та звертаються до Model
    @Override
    public void add() {
        m.add();
    }

    @Override
    public void delete() {
        m.delete();
    }

    @Override
    public void edit() {
        m.edit();
    }

    public String toString(){
        return m.toString();
    }

    @Override
    public void save() {
        m.save();
    }
}