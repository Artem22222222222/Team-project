package src3;

import src.OldUI;

public interface Imodel {
    void add(UI ui, Base base);

    void delete(Contact contact);

    void edit(Contact oldContact, Contact newContact);

}
