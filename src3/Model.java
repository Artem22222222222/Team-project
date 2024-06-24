package src3;

import javax.swing.*;
import java.awt.*;

public class Model implements Imodel{
    Base base = new Base();
    //змінні для додавання та зміни контакту
    private int phone;
    private String name;
    private String email;
    private String gender;

    public Model(){
        base.getContactList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        base.getContactList().setCellRenderer(new MyCellRenderer(this));
    }


    public void add(UI ui) {
        //додавання данних у base
        if (!ui.getNameField().getText().isEmpty() && !ui.getPhoneField().getText().isEmpty() && !ui.getEmailField().getText().isEmpty()) {
            name = ui.getNameField().getText();
            try {
                phone = Integer.parseInt(ui.getPhoneField().getText());
            } catch (Exception e1) {
                ui.getConfirmButton().setBounds(50, 165, 220, 30);
                ui.getConfirmButton().setText("Телефон має бути цифрами");
                ui.getConfirmButton().setBackground(Color.red);
                return;
            }

            email = ui.getNameField().getText();
            gender = ui.getGenderSelectionMan().isSelected() ? "Чоловік" : "Жінка";
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


    public void delete(UI ui) {
        //видалення данних з base
        if (base.getContactList().getSelectedIndex() != -1) {
            base.getContacts().remove(base.getContactList().getSelectedIndex());
            base.getListModel().remove(base.getContactList().getSelectedIndex());
        }
    }

    @Override
    public void edit(UI ui) {
        //зміна даних у base
        Contact selectedContact = base.getContacts().get(base.getContactList().getSelectedIndex());
        name = ui.getNameFieldEdit().getText();
        email = ui.getEmailFieldEdit().getText();
        gender = ui.getGenderSelectionMan().isSelected() ? "Чоловік" : "Жінка";

        if (!ui.getNameFieldEdit().getText().isEmpty() && !ui.getPhoneFieldEdit().getText().isEmpty() && !ui.getEmailFieldEdit().getText().isEmpty()) {

            try {
                phone = Integer.parseInt(ui.getPhoneFieldEdit().getText());
            } catch (Exception e1) {
                ui.getConfirmButton().setBounds(50, 165, 220, 30);
                ui.getConfirmButton().setText("Телефон має бути цифрами");
                ui.getConfirmButton().setBackground(Color.red);
                return;
            }

            selectedContact.setPhone(phone);
            selectedContact.setName(name);
            selectedContact.setEmail(email);
            selectedContact.setGender(gender);

            base.getListModel().set(base.getContactList().getSelectedIndex(), selectedContact);
            base.getContacts().set(base.getContactList().getSelectedIndex(), selectedContact);

            ui.getEditFrame().dispose();
        } else {
            ui.getConfirmButton().setBounds(50, 165, 200, 30);
            ui.getConfirmButton().setText("Заповніть всі поля");
            ui.getConfirmButton().setBackground(Color.red);
        }
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Ім'я: " + name + ", Телефон: " + phone + ", Пошта: " + email + ", Стать: " + gender;
    }
}

