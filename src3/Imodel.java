package src3;

import src.OldUI;

public interface Imodel {
    void add(UI ui, Base base);

    void delete(UI ui, Base base);

    void edit(UI ui,Base base);

    void save();
}
