package src3;

import src3.Base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Icontroler, ActionListener {
    private Model model;
    private UI ui;

    public Controller() {
        this.ui = new UI(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        switch (b.getText()) {
            case "+":
                ui.add();
                break;
            case "Delete":
                delete();
                break;
            case "Edit":
                edit();
                break;
            case "Confirm":
                add( ui.getBase());
        }
    }

    @Override
    public void add(Base base) {
        // Реализация добавления данных в модель
        model.add(ui, base);
    }

    @Override
    public void delete() {
        // Реализация удаления данных из модели
        model.delete();
    }

    @Override
    public void edit() {
        // Реализация редактирования данных в модели
        model.edit();
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

    public void setM(Model model) {
        this.model = model;
    }
}