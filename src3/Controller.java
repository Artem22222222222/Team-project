package src3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Icontroler, ActionListener {
    //зміння для зв'язку класів
    private Model model;
    private UI ui;
    private boolean isadd;


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        //обробка основних кнопок
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
                //обробка кнопок підтвердження
            case "Confirm", "Телефон має бути цифрами", "Заповніть всі поля":
                if (isadd)
                    model.add(ui);
                else {
                    model.edit(ui);
                }
                break;
        }
    }
//функції для зв'язку між класами
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