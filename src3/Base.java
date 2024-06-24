package src3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Base implements Saver{
    private List<Contact> contacts = new ArrayList<>();
    private DefaultListModel<Contact> listModel = new DefaultListModel<>();
    private JList<Contact> contactList = new JList<>(listModel);
    public Base(){

    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public DefaultListModel<Contact> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<Contact> listModel) {
        this.listModel = listModel;
    }

    public JList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(JList<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public void save() {

    }
}
