public class MainNewVer {
    public static void main(String[] args){
        Controller c = new Controller();
        c.setM(new Model());

        // Добавим открытие основного окна после установки модели и контролера
        IUI mainUI = new IUI() {
            @Override
            public void add() {

            }

            @Override
            public void edit() {

            }

            @Override
            public void setVisible(boolean b) {

            }
        };
        mainUI.setVisible(true);
    }
}