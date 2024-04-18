package src2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class UI extends JFrame implements ActionListener {
    private List<Contact> contacts = new ArrayList<>();
    private DefaultListModel<Contact> listModel = new DefaultListModel<>();
    private JList<Contact> contactList = new JList<>(listModel);

    //Створюю інші кнопочки
    private JTextField nameFieldEdit = new JTextField();
    private JTextField phoneFieldEdit = new JTextField();
    private JTextField emailFieldEdit = new JTextField();
    private JRadioButton genderSelectionManEdit = new JRadioButton("Чоловік");
    private JRadioButton genderSelectionWomanEdit = new JRadioButton("Жінка");

    int selectedIndex = contactList.getSelectedIndex();

    //Просто створюю кнопочки
    private JButton newContact = new JButton("+");
    private JButton deleteButton = new JButton("Delete");
    private JButton editButton = new JButton("Edit");
    private JTextField nameField = new JTextField("");
    private JTextField phoneField = new JTextField("");
    private JTextField emailField = new JTextField("");
    private JRadioButton genderSelectionMan = new JRadioButton("Чоловік");
    private JRadioButton genderSelectionWoman = new JRadioButton("Жінка");

    public UI() {
        super("Телефона Книга");
        super.setBounds(250, 300, 650, 550);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.GRAY);
        grayPanel.setPreferredSize(new Dimension(650, 75));
        grayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(grayPanel, BorderLayout.NORTH);

        grayPanel.add(newContact);
        grayPanel.add(deleteButton);
        grayPanel.add(editButton);
        getContentPane().add(new JScrollPane(contactList), BorderLayout.CENTER);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(genderSelectionMan);
        buttonGroup.add(genderSelectionWoman);

        //Додаю параметри і ActionListener-и
        newContact.setPreferredSize(new Dimension(50, 50));
        newContact.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);
        //Роблю кожну строку з інформацією клікабільною
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        contactList.setCellRenderer(new MyCellRenderer());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        selectedIndex = contactList.getSelectedIndex();
        switch (b.getText()) {
            case "+":
                JFrame newFrame = new JFrame("Додати Контакт");
                newFrame.setBounds(200, 250, 350, 250);
                newFrame.setLayout(null);
                newFrame.setVisible(true);

                genderSelectionMan.setBounds(100, 125, 75, 25);
                genderSelectionMan.setSelected(true);
                newFrame.add(genderSelectionMan);

                genderSelectionWoman.setBounds(175, 125, 75, 25);
                newFrame.add(genderSelectionWoman);

                JLabel nameLabel = new JLabel("Ім'я:");
                nameLabel.setBounds(10, 15, 75, 30);
                newFrame.add(nameLabel);

                nameField.setBounds(40, 15, 150, 30);
                newFrame.add(nameField);

                JLabel genderLabel = new JLabel("Виберіть стать :");
                genderLabel.setBounds(10, 125, 105, 25);
                newFrame.add(genderLabel);

                JLabel phoneLabel = new JLabel("Номер телефона:");
                phoneLabel.setBounds(10, 50, 150, 30);
                newFrame.add(phoneLabel);

                phoneField.setBounds(115, 50, 150, 30);
                newFrame.add(phoneField);

                JLabel emailLabel = new JLabel("Електронна пошта:");
                emailLabel.setBounds(10, 85, 150, 30);
                newFrame.add(emailLabel);

                emailField.setBounds(125, 85, 150, 30);
                newFrame.add(emailField);

                JButton confirmButton = new JButton("Confirm");
                confirmButton.setBackground(Color.GREEN);
                confirmButton.setBounds(200, 165, 100, 30);
                newFrame.add(confirmButton);

                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //перевірки коректного вводу
                        if (!nameField.getText().isEmpty() && !phoneField.getText().isEmpty() && !emailField.getText().isEmpty()) {
                                int phone;
                                String name = nameField.getText();
                                try {
                                    phone = Integer.valueOf(phoneField.getText());
                                }catch (Exception e1){
                                    confirmButton.setBounds(50,165, 220, 30);
                                    confirmButton.setText("Телефон має бути цифрами");
                                    confirmButton.setBackground(Color.red);
                                    return;
                                }
                                String email = emailField.getText();
                                String gender = genderSelectionMan.isSelected() ? "Чоловік" : "Жінка";
                                Contact contact = new Contact(name, phone, email, gender);
                                contacts.add(contact);
                                listModel.addElement(contact);
                                newFrame.dispose();
                                nameField.setText("");
                                emailField.setText("");
                                phoneField.setText("");

                        }else{
                            confirmButton.setBounds(50,165, 200, 30);
                            confirmButton.setText("Заповніть всі поля");
                            confirmButton.setBackground(Color.red);
                        }
                    }
                });
                break;
            case "Delete":
                if (selectedIndex != -1) {
                    contacts.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
                break;
            case "Edit":
                if (selectedIndex != -1) {
                    Contact selectedContact = contacts.get(selectedIndex);
                    // Робимо нове вікно для редагування контактів
                    JFrame editFrame = new JFrame("Редагувати контакт");
                    editFrame.setBounds(200, 250, 350, 250);
                    editFrame.setLayout(null);
                    editFrame.setVisible(true);

                    JLabel nameLabelEdit = new JLabel("Ім'я:");
                    nameLabelEdit.setBounds(10, 15, 75, 30);
                    editFrame.add(nameLabelEdit);
                    nameFieldEdit.setText(selectedContact.name);
                    nameFieldEdit.setBounds(40, 15, 150, 30);
                    editFrame.add(nameFieldEdit);

                    JLabel genderLabelEdit = new JLabel("Виберіть стать :");
                    genderLabelEdit.setBounds(10, 125, 105, 25);
                    editFrame.add(genderLabelEdit);

                    genderSelectionMan.setBounds(100, 125, 75, 25);
                    genderSelectionWoman.setBounds(175, 125, 75, 25);
                    editFrame.add(genderSelectionMan);
                    editFrame.add(genderSelectionWoman);
                    if (selectedContact.gender.equals("Чоловік")) {
                        genderSelectionMan.setSelected(true);
                    } else {
                        genderSelectionWoman.setSelected(true);
                    }

                    JLabel phoneLabelEdit = new JLabel("Номер телефона:");
                    phoneLabelEdit.setBounds(10, 50, 150, 30);
                    editFrame.add(phoneLabelEdit);
                    phoneFieldEdit.setText(String.valueOf(selectedContact.phone));
                    phoneFieldEdit.setBounds(115, 50, 150, 30);
                    editFrame.add(phoneFieldEdit);

                    JLabel emailLabelEdit = new JLabel("Електронна пошта:");
                    emailLabelEdit.setBounds(10, 85, 150, 30);
                    editFrame.add(emailLabelEdit);
                    emailFieldEdit.setText(selectedContact.email);
                    emailFieldEdit.setBounds(125, 85, 150, 30);
                    editFrame.add(emailFieldEdit);

                    JButton confirmEditButton = new JButton("Confirm");
                    confirmEditButton.setBackground(Color.GREEN);
                    confirmEditButton.setBounds(200, 165, 100, 30);
                    editFrame.add(confirmEditButton);

                    confirmEditButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int phone;
                            //перевірки коректного вводу
                            if (!nameFieldEdit.getText().isEmpty() && !phoneFieldEdit.getText().isEmpty() && !emailFieldEdit.getText().isEmpty()) {

                                try {
                                    phone = Integer.valueOf(phoneFieldEdit.getText());
                                } catch (Exception e1) {
                                    confirmEditButton.setBounds(50, 165, 220, 30);
                                    confirmEditButton.setText("Телефон має бути цифрами");
                                    confirmEditButton.setBackground(Color.red);
                                    return;
                                }
                                selectedContact.phone = phone;
                                selectedContact.name = nameFieldEdit.getText();

                                selectedContact.email = emailFieldEdit.getText();
                                selectedContact.gender = genderSelectionMan.isSelected() ? "Чоловік" : "Жінка";
                                listModel.set(selectedIndex, selectedContact);

                                editFrame.dispose();
                            }else {
                                confirmEditButton.setBounds(50,165, 200, 30);
                                confirmEditButton.setText("Заповніть всі поля");
                                confirmEditButton.setBackground(Color.red);
                            }
                        }
                    });
                }
                break;
        }
    }

    private static class Contact {
        private String name;
        private int phone;
        private String email;
        private String gender;

        public Contact(String name, int phone, String email, String gender) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.gender = gender;
        }



        @Override
        public String toString() {

            return "Ім'я: " + name + ", Телефон: " + phone + ", Пошта: " + email + ", Стать: " + gender;
        }
    }

    private static class MyCellRenderer extends JLabel implements ListCellRenderer<Contact> {
        private static final Font FONT = new Font("Basic", Font.BOLD, 13);

        public MyCellRenderer() {
            setOpaque(true);
            setFont(FONT);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Contact> list, Contact contact, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setText(contact.toString());

            // Робимо квадратну обводку
            setBorder(BorderFactory.createLineBorder(Color.BLACK));

            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }

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

    public JTextField getNameFieldEdit() {
        return nameFieldEdit;
    }

    public void setNameFieldEdit(JTextField nameFieldEdit) {
        this.nameFieldEdit = nameFieldEdit;
    }

    public JTextField getPhoneFieldEdit() {
        return phoneFieldEdit;
    }

    public void setPhoneFieldEdit(JTextField phoneFieldEdit) {
        this.phoneFieldEdit = phoneFieldEdit;
    }

    public JTextField getEmailFieldEdit() {
        return emailFieldEdit;
    }

    public void setEmailFieldEdit(JTextField emailFieldEdit) {
        this.emailFieldEdit = emailFieldEdit;
    }

    public JRadioButton getGenderSelectionManEdit() {
        return genderSelectionManEdit;
    }

    public void setGenderSelectionManEdit(JRadioButton genderSelectionManEdit) {
        this.genderSelectionManEdit = genderSelectionManEdit;
    }

    public JRadioButton getGenderSelectionWomanEdit() {
        return genderSelectionWomanEdit;
    }

    public void setGenderSelectionWomanEdit(JRadioButton genderSelectionWomanEdit) {
        this.genderSelectionWomanEdit = genderSelectionWomanEdit;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public JButton getNewContact() {
        return newContact;
    }

    public void setNewContact(JButton newContact) {
        this.newContact = newContact;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JRadioButton getGenderSelectionMan() {
        return genderSelectionMan;
    }

    public void setGenderSelectionMan(JRadioButton genderSelectionMan) {
        this.genderSelectionMan = genderSelectionMan;
    }

    public JRadioButton getGenderSelectionWoman() {
        return genderSelectionWoman;
    }

    public void setGenderSelectionWoman(JRadioButton genderSelectionWoman) {
        this.genderSelectionWoman = genderSelectionWoman;
    }
}

