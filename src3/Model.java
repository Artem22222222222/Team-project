package src3;

import src2.OldUI2;
import src3.Base;
import src3.Contact;
import src3.Imodel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Model implements Imodel {
    Base base = new Base();

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
    public void delete(UI ui, Base base) {
        if (ui.selectedIndex != -1) {
            base.getContacts().remove(ui.selectedIndex);
            base.getListModel().remove(ui.selectedIndex);
        }
    }

    @Override
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

    @Override
    public void save() {

    }
}