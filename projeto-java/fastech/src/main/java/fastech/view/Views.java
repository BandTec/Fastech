package fastech.view;

import fastech.controller.Controller;
import fastech.model.Machine;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Jorge
 */
public class Views {

    public static void main(String[] args) {
        Controller c = new Controller();
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu email:");
        String email = leitor.nextLine().trim();

        System.out.println("Digite sua senha:");
        String senha = leitor.nextLine().trim();
        c.login(email, senha);

        List<Machine> listMachines = c.showAllMachine();

        if (listMachines.size() > 0) {
            System.out.println("Escolha o número da sua máquina:");
            Integer contador = 0;
            for (Machine m : listMachines) {
                contador++;
                System.out.print(contador + " - ");
                System.out.println(m.getName());
            }
            Integer choiceMachine = Integer.valueOf(leitor.nextLine().trim());

            Integer contadorMachine = 0;
            for (Machine m : listMachines) {
                contadorMachine++;
                if (choiceMachine == contadorMachine) {
                    c.setGlobalMachine(m.getName());

                    System.out.println("ok");
                }
            }
        } else {
            System.out.println("Digite o nome da sua nova máquina:");
            String newMachine = leitor.nextLine().trim();
            c.registerMachine(newMachine);
        }

        c.setGlobalVarComponentList();
        
        Timer timer = new Timer();

        Integer seg = 5000;

        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                c.insertData("Cpu");
                c.insertData("Memory");
                c.insertData("Disk");
                
            }
        };
        
        timer.scheduleAtFixedRate(tarefa, 0, seg);
//        c.setGlobalMachine("XPTO");
//
//        c.insertData("Disk");
        // TYPES "Cpu", "Memory", "Disk", OR SELECT * FROM Types;
    }
}
