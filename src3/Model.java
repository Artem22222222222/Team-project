package src3;

import src.OldUI;
import src2.OldUI2;
import src3.Base;
import src3.Contact;
import src3.Imodel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Model implements Imodel{
    Base base = new Base();
    private int phone;
    private String name;
    private String email;
    private String gender;

    public Model(){
        base.getContactList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        base.getContactList().setCellRenderer(new MyCellRenderer(this));
    }


    public void add(UI ui, Base base) {
        if (!ui.getNameField().getText().isEmpty() && !ui.getPhoneField().getText().isEmpty() && !ui.getEmailField().getText().isEmpty()) {
            name = ui.getNameField().getText();
            try {
                phone = Integer.valueOf(ui.getPhoneField().getText());
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


    public void delete(UI ui, Base base) {
        if (ui.selectedIndex != -1) {
            base.getContacts().remove(ui.selectedIndex);
            base.getListModel().remove(ui.selectedIndex);
        }
    }


    public void edit(UI ui, Base base) {
        Contact selectedContact = base.getContacts().get(ui.selectedIndex);
            int phone;
            if (!ui.getNameFieldEdit().getText().isEmpty() && !ui.getPhoneFieldEdit().getText().isEmpty() && !ui.getEmailFieldEdit().getText().isEmpty()) {

                try {
                    phone = Integer.valueOf(ui.getPhoneFieldEdit().getText());
                } catch (Exception e1) {
                    ui.getConfirmButton().setBounds(50, 165, 220, 30);
                    ui.getConfirmButton().setText("Телефон має бути цифрами");
                    ui.getConfirmButton().setBackground(Color.red);
                    return;
                }
                selectedContact.setPhone(phone);
                selectedContact.setName(ui.getPhoneField().getText());

                selectedContact.setEmail(ui.getEmailFieldEdit().getText());
                selectedContact.setGender(ui.getGenderSelectionMan().isSelected() ? "Чоловік" : "Жінка");
                base.getListModel().set(ui.selectedIndex,base.getContacts().get(ui.getSelectedIndex()));

                ui.getNewFrame().dispose();
            } else {
                ui.getConfirmButton().setBounds(50, 165, 200, 30);
                ui.getConfirmButton().setText("Заповніть всі поля");
                ui.getConfirmButton().setBackground(Color.red);
            }
        }


    public void save() {

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

