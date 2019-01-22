package com.tgp;

import com.tgp.exceptions.QuitException;
import com.tgp.hero.Orc;
import com.tgp.save.ProgressManager;
import com.tgp.training.TrainingCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Orc hero = new Orc();
        while (true) {
            try {
                System.out.println("*****Меню*****");
                System.out.println("1. Пойти на арену" +
                        "\n2. Улучшить навыки" +
                        "\n3. Статистика" +
                        "\n4. Сохраниться" +
                        "\n5. Загрузиться" +
                        "\n6. Нажмите любую кнопку, чтобы выйти");
                Scanner sc = new Scanner(System.in);
                System.out.print("Ваш выбор: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        hero.toArena();
                        break;
                    }
                    case 2: {
                        TrainingCamp.getInstance().increaseAttack(hero);
                        break;
                    }
                    case 3: {
                        System.out.println(hero);
                        break;
                    }
                    case 4: {
                        ProgressManager.getInstance().tryToSaveData(hero);
                        break;
                    }
                    case 5: {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("\nВведите имя вашего персонажа: ");
                        String heroName = reader.readLine();
                        hero = ProgressManager.getInstance().tryToLoadData(heroName);
                        break;
                    }
                    default: {
                        System.exit(0);
                    }
                }
            } catch (QuitException e) {
                System.err.println("***Игрок вернулся в меню.***");
            } catch (IOException e) {
                System.err.println("Ошибка при чтении...");
            }

        }
    }
}
