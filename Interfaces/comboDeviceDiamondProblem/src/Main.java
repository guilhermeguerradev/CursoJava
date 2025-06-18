import model.entities.ComboDevice;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        ComboDevice comboDevice = new ComboDevice("2081");
        comboDevice.processDoc("My dissertation");
        comboDevice.print("My dissertation");
        System.out.println("Scan result: " + comboDevice.scan());
    }

}