package src3;

import src3.Base;
import src3.Imodel;

import java.awt.*;
import java.io.*;
import java.util.List;

public class ModelNewVer implements Imodel {
    private Base base = new Base();

    @Override
    public void add(UI ui, Base base) {
        if (!ui.getNameField().getText().isEmpty() && !ui.getPhoneField().getText().isEmpty() && !ui.getEmailField().getText().isEmpty()) {
            int phone;
            String name = ui.getNameField().getText();
            try {
                phone = Integer.valueOf(ui.getPhoneField().getText());
            } catch (Exception e1) {
                ui.getConfirmButton().setBounds(50, 165, 220, 30);
                ui.getConfirmButton().setText("Телефон має бути цифрами");
                ui.getConfirmButton().setBackground(Color.red);
                return;
            }
            String email = ui.getEmailField().getText();
            String gender = ui.getGenderSelectionMan().isSelected() ? "Чоловік" : "Жінка";
            Contact contact = new Contact(name, phone, email, gender);
            base.getContacts().add(contact);
            base.getListModel().addElement(contact);
            ui.getNewFrame().dispose();
            ui.getNameField().setText("");
            ui.getEmailField().setText("");
            ui.getPhoneField().setText("");
        } else {
            ui.getConfirmButton().setBounds(50, 165, 200, 30);
            ui.getConfirmButton().setText("Заповніть всі поля");
            ui.getConfirmButton().setBackground(Color.red);
        }
    }

    @Override
    public void delete(Contact contact) {
        List<Contact> contacts = base.getContacts();
        contacts.remove(contact);
        base.getListModel().removeElement(contact);
    }

    @Override
    public void edit(Contact oldContact, Contact newContact) {
        List<Contact> contacts = base.getContacts();
        int index = contacts.indexOf(oldContact);
        contacts.set(index, newContact);
        base.getListModel().removeElement(oldContact);
        base.getListModel().addElement(newContact);
    }

    @Override
    public void saveToFile(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(base.getContacts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            List<Contact> contacts = (List<Contact>) inputStream.readObject();
            base.setContacts(contacts);
            base.getListModel().removeAllElements();
            for (Contact contact : contacts) {
                base.getListModel().addElement(contact);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}