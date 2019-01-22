package com.tgp;

import com.tgp.exceptions.QuitException;
import com.tgp.hero.Orc;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Orc orc = new Orc();
        while (true) {
            try {
                System.out.println("*****Меню*****");
                System.out.println("1. Пойти на арену\n2. Улучшить навыки\n3. Статистика\n4. Нажмите любую кнопку, чтобы выйти");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        orc.toArena();
                        break;
                    }
                    case 2: {
                        //training camp
                        break;
                    }
                    case 3: {
                        System.out.println(orc);
                        break;
                    }
                    default: {
                        System.exit(0);
                    }
                }
            } catch (QuitException e) {
                System.err.println("***Игрок вернулся в меню.***");
            }

        }
    }
}
