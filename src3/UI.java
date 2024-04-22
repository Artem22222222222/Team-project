package src3;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame implements IUI {
    //після відмальовки звертається до Controler
    private Base base = new Base();
    Controller controller;

    JFrame newFrame;
    JFrame mainFrame;
    //Створюю інші кнопочки
    private JTextField nameFieldEdit = new JTextField();
    private JTextField phoneFieldEdit = new JTextField();
    private JTextField emailFieldEdit = new JTextField();
    private JRadioButton genderSelectionManEdit = new JRadioButton("Чоловік");
    private JRadioButton genderSelectionWomanEdit = new JRadioButton("Жінка");

    int selectedIndex = base.getContactList().getSelectedIndex();

    //Просто створюю кнопочки
    private JButton newContact = new JButton("+");
    private JButton deleteButton = new JButton("Delete");
    private JButton editButton = new JButton("Edit");
    private JTextField nameField = new JTextField("");
    private JTextField phoneField = new JTextField("");
    private JTextField emailField = new JTextField("");
    private JRadioButton genderSelectionMan = new JRadioButton("Чоловік");
    private JRadioButton genderSelectionWoman = new JRadioButton("Жінка");
    private JButton confirmButton;

    public UI(Controller c) {
        mainFrame = new JFrame("Телефона Книга");
        mainFrame.setBounds(250, 300, 650, 550);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        this.controller = c;

        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.GRAY);
        grayPanel.setPreferredSize(new Dimension(650, 75));
        grayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainFrame.getContentPane().add(grayPanel, BorderLayout.NORTH);

        grayPanel.add(newContact);
        grayPanel.add(deleteButton);
        grayPanel.add(editButton);
        getContentPane().add(new JScrollPane(base.getContactList()), BorderLayout.CENTER);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(genderSelectionMan);
        buttonGroup.add(genderSelectionWoman);

        //Додаю параметри і ActionListener-и
        newContact.setPreferredSize(new Dimension(50, 50));
        newContact.addActionListener(c);
        deleteButton.addActionListener(c);
        editButton.addActionListener(c);
        //Роблю кожну строку з інформацією клікабільною
        base.getContactList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        base.getContactList().setCellRenderer(new MyCellRenderer());
        setVisible(true);
    }
    @Override
    public void add() {
        newFrame = new JFrame("Додати Контакт");
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

        confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.GREEN);
        confirmButton.setBounds(200, 165, 100, 30);
        newFrame.add(confirmButton);

        confirmButton.addActionListener(controller);


    }
    @Override
    public void edit() {

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

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JFrame getNewFrame() {
        return newFrame;
    }

    public void setNewFrame(JFrame newFrame) {
        this.newFrame = newFrame;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}