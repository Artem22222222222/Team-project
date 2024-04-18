package src2;

public interface Icontroler {
    //Model це аналіз програми у функціях -- лише взаємодія з функціями
    //функції виликаються з UI та звертаються до Model
    void add();
    void delete();
    void edit();
    String toString();
    //зберігання данних
    void save();
}
