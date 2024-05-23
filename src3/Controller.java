package src3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Icontroler, ActionListener {
    private Model model;
    private UI ui;

    public Controller() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        switch (b.getText()) {
            case "+":
                ui.add();
                break;
            case "Delete":
                ui.delete();
                break;
            case "Edit":
                ui.edit();
                break;
            case "Confirm":
                add( model.base);
            case "Телефон має бути цифрами":
                add( model.base);
            case "Заповніть всі поля":
                add( model.base);
        }
    }

    @Override
    public void add(Base base) {
        // Реализация добавления данных в модель
        model.add(ui, base);
    }

    @Override
    public void delete(Base base) {
        // Реализация удаления данных из модели
        model.delete(ui, base);
    }

    @Override
    public void edit(Base base) {
        // Реализация редактирования данных в модели
        model.edit(ui, base);
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
        this.ui = new UI(this);
    }

    public Model getModel() {
        return model;
    }
}