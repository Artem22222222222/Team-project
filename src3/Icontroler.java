package src3;

import java.util.Base64;

public interface Icontroler {
    //src3.Model це аналіз програми у функціях -- лише взаємодія з функціями
    //функції виликаються з src3.UI та звертаються до src3.Model
    void add(Base base);
    void delete(Base base);
    void edit(Base base);
    String toString();
    //зберігання данних
    void save();
}
