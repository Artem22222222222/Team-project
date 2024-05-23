package src3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Icontroler, ActionListener {
    private Model model;
    private UI ui;
    private boolean isadd;

    public Controller() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        switch (b.getText()) {
            case "+":
                ui.add();
                isadd = true;
                break;
            case "Delete":
                ui.delete();
                break;
            case "Edit":
                ui.edit();
                isadd = false;
                break;
            case "Confirm", "Телефон має бути цифрами", "Заповніть всі поля":
                if (isadd)
                    model.add(ui);
                else {
                    model.edit(ui);
                    System.out.print(2);
                }
                break;
        }
    }

    @Override
    public String toString() {
        // Реализация преобразования данных в строку
        return model.toString();
    }

    @Override
    public void save() {
        // Реализация сохранения данных
        model.save();
    }

    public void setModel(Model model) {
        this.model = model;
        this.ui = new UI(this);
    }

    public Model getModel() {
        return model;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public boolean isIsadd() {
        return isadd;
    }

    public void setIsadd(boolean isadd) {
        this.isadd = isadd;
    }
}