package fastech.view;

import fastech.controller.Controller;
import fastech.model.Machine;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Views {

    public static void main(String[] args) throws IOException {
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
            System.out.println("0 - Cadastrar máquina nova");
            Integer contador = 0;
            for (Machine m : listMachines) {
                contador++;
                System.out.print(contador + " - ");
                System.out.println(m.getName());
            }
            Integer choiceMachine = Integer.valueOf(leitor.nextLine().trim());

            if (choiceMachine.equals(0)) {
                System.out.println("Digite o nome da sua nova máquina:");
                String newMachine = leitor.nextLine().trim();
                c.registerMachine(newMachine);
                
            } else {
                Integer contadorMachine = 0;
                for (Machine m : listMachines) {
                    contadorMachine++;
                    if (Objects.equals(choiceMachine, contadorMachine)) {
                        c.setGlobalMachine(m.getName());

                        System.out.println("ok");
                    }
                }
            }
        } else {
            System.out.println("Digite o nome da sua nova máquina:");
            String newMachine = leitor.nextLine().trim();
            c.registerMachine(newMachine);
        }

        c.setGlobalVarComponentList();
        
        System.out.println("Para parar o monitoramento digite Ctrl + C");
        
        Timer timer = new Timer();
        Integer seg = 1000;
        Boolean run = true;

        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                try {
                    c.insertData("Cpu");
                } catch (Exception ex) {
                    Logger.getLogger(Views.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    c.insertData("Memory");
                } catch (Exception ex) {
                    Logger.getLogger(Views.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    c.insertData("Disk");
                } catch (Exception ex) {
                    Logger.getLogger(Views.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        if(run) {
            timer.scheduleAtFixedRate(tarefa, 0, seg);
        }
    }
}
