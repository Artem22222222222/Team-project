
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Icontroler, ActionListener {
    private Model model;
    private UI mainUI;

    public Controller() {
        this.model = new Model();
        this.mainUI = new UI();
        mainUI.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Add":
                openNewEntryWindow();
                break;
            case "Delete":
                delete();
                break;
            case "Edit":
                edit();
                break;
        }
    }

    private void openNewEntryWindow() {
        JFrame newEntryFrame = new JFrame("New Entry");
        JPanel panel = new JPanel();
        JTextField nameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField ageField = new JTextField(20);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String address = addressField.getText();
                int age = Integer.parseInt(ageField.getText());
                // Добавьте код для сохранения этих данных в модели
            }
        });

        panel.add(saveButton);

        newEntryFrame.getContentPane().add(panel);
        newEntryFrame.setSize(300, 200);
        newEntryFrame.setVisible(true);
    }

    @Override
    public void add() {
        // Реализация добавления данных в модель
        model.add();
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