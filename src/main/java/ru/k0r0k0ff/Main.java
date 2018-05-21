package main.java.ru.k0r0k0ff;

public class Main {

    public static void main(String[] args) {

        BusinessLogic bl = new BusinessLogic();

        bl.fillInitialArray();
        bl.parseInitialArrayAndCreateDataForOutput(bl.arr);
        bl.showResult(bl.data);
    }
}

