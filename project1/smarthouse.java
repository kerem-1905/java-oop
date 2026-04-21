import java.util.Arrays;
import java.util.Scanner;

public class smarthouse {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        lightsystem light = new lightsystem();
        airconditioner ac = new airconditioner();
        internet Internet = new internet();

        int choice;
        boolean systemRunning = true;

        int choice_a;
        int choice_l;
        int choice_i;

        do{
            System.out.println("************************************");
            System.out.println("Welcome to Smarthouse Settings");
            System.out.println("Select the system you want to adjust (1-4)");
            System.out.println("************************************");
            System.out.println("1. Light System");
            System.out.println("2. Interior Air Conditioning System");
            System.out.println("3. WiFi System");
            System.out.println("4. Exit Settings");
            System.out.println("************************************");

            choice = scanner.nextInt();

            switch(choice){
                case 1 -> {
                    System.out.println("Light System Settings");
                    System.out.println("Choose an option (1-4): ");
                    System.out.println("************************************");
                    System.out.println("1. View System");
                    System.out.println("2. Change Light Level");
                    System.out.println("3. Change Light Color");
                    System.out.println("4. Quit to Main Menu");
                    System.out.println("************************************");
                    choice_l = scanner.nextInt();

                    switch (choice_l) {
                        case 1 -> {
                            System.out.println("Light level: " + light.lightlevel);
                            System.out.println("Light color: " + light.lightcolor);
                        }

                        case 2 -> {
                            System.out.println("Set brightness (1-100): ");
                            light.lightlevel = scanner.nextInt();
                            if (light.lightlevel <= 100 && light.lightlevel >= 0) {
                                System.out.println("Current light level: %" + light.lightlevel);
                            }
                            else {
                                System.out.println("Invalid input, going back to main menu");
                                continue;
                            }
                        }

                        case 3 -> {
                            System.out.println("Choose a color (blue/white/yellow/red/black): ");
                            light.lightcolor = scanner.nextLine();
                            if (Arrays.asList(light.coloroptions).contains(light.lightcolor)) {
                                System.out.println("Light color is now " + light.lightcolor);
                            } else {
                                System.out.println("Please enter an available color");
                            }
                        }

                        case 4 -> systemRunning = false;

                        default -> {
                            System.out.println("Invalid input");
                            continue;
                        }

                    }
                }
                case 2 -> {
                    System.out.println("Air Conditioning Settings");
                    System.out.println("************************************");
                    System.out.println("Choose an option (1-5): ");
                    System.out.println("1. Change Temperature");
                    System.out.println("2. Operate in Eco Mode");
                    System.out.println("3. Operate in Performance Mode");
                    System.out.println("4. View System");
                    System.out.println("5. Quit to Main Menu");
                    System.out.println("************************************");
                    choice_a = scanner.nextInt();

                    switch (choice_a) {
                        case 1 -> {
                            System.out.println("The air conditioner is set to " + ac.actemp + " °C on default");
                            System.out.println("Enter the temperature you want to adjust (18-36 °C): ");
                            ac.actemp = scanner.nextInt();
                            if (ac.actemp <= 36 && ac.actemp >= 18) {
                                System.out.println("Interior temperature is set to " + ac.actemp + "°C");
                            } else {
                                System.out.println("Invalid input, going back to main menu");
                                continue;
                            }
                        }

                        case 2 -> {
                            System.out.println("Operating in eco mode now");
                            ac.mode = "Eco";
                        }

                        case 3 -> {
                            System.out.println("Operating in performance mode now");
                            ac.mode = "Performance";
                        }

                        case 4 -> {
                            System.out.println("Temperature: " + ac.actemp + "°C");
                            System.out.println("Operating in " + ac.mode.toUpperCase() + " mode");
                        }
                        case 5 -> {
                            System.out.println("Going back to main menu");
                            continue;
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Internet System Control");
                    System.out.println("************************************");
                    System.out.println("Choose an option (1-4):");
                    System.out.println("1. Turn On/Off");
                    System.out.println("2. Connect A Device");
                    System.out.println("3. View System");
                    System.out.println("4. Quit to Main Menu");
                    System.out.println("************************************");
                    choice_i = scanner.nextInt();

                    switch (choice_i) {
                        case 1 -> {
                            Internet.isOn = !Internet.isOn;
                            if (Internet.isOn) {
                                System.out.println("The Wi-Fi is on now");
                            }
                            else {
                                System.out.println("The Wi-Fi is off now");
                            }
                        }
                        case 2 -> {
                            if(Internet.isOn){
                                Internet.deviceConnected = Internet.deviceConnected + 1;
                                System.out.println("The amount of devices connected to your Wi-Fi: " + Internet.deviceConnected);
                            }
                            else{
                                System.out.println("Wi-Fi isn't turned on");
                            }
                        }

                        case 3 -> {
                            System.out.println("System working: " + Internet.isOn);
                            System.out.println(Internet.deviceConnected + " devices connected");
                        }

                        case 4 -> {
                            System.out.println("Going back to main menu");
                            continue;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Have a good day");
                    systemRunning = false;
                }
                default -> {
                    System.out.println("Please enter a valid value");
                    continue;
                }
            }
        }while(systemRunning);
    }
}
