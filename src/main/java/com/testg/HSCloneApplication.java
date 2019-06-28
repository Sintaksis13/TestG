package com.testg;

import com.testg.cards.creatures.Minion;
import com.testg.database.MinionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class HSCloneApplication {
    private static final Logger log = LoggerFactory.getLogger(HSCloneApplication.class);

    public static void main(String[] args) {
        log.error("Application starting..." + log.isDebugEnabled());
        ApplicationContext context = SpringApplication.run(HSCloneApplication.class);
        log.error("Application started.");

        MinionRepository repository = context.getBean(MinionRepository.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose option:");
            System.out.println("1) Add");
            System.out.println("2) Find");
            System.out.println("3) Delete");
            System.out.println("Any) Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    byte cost = scanner.nextByte();
                    System.out.print("Enter ap: ");
                    int ap = scanner.nextInt();
                    System.out.print("Enter hp: ");
                    int hp = scanner.nextInt();
                    repository.save(new Minion(name, ap, hp, cost));
                    break;
                }
                case 2: {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name.equals("all")) {
                        System.out.println("ALL: " + repository.findAll());
                    } else {
                        System.out.println("Here this minion: " + repository.findByName(name));
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    repository.deleteByName(name);
                    break;
                }
                default: {
                    System.exit(0);
                }
            }
        }
    }
}
