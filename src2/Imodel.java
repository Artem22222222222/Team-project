package src2;

public interface Imodel {
    //Model це обрахунки програми у функціях -- лише взаємодія з данними
    void add();
    void delete();
    void edit();
    String toString();
    //зберігання данних
    void save();
}