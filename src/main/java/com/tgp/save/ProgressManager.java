package com.tgp.save;

import com.tgp.hero.Orc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProgressManager {
    private static final String DELIMITER = ";";
    private static final String DATA_BASE_NAME = "data.txt";
    private static final ProgressManager instance = new ProgressManager();

    public static ProgressManager getInstance() {
        return instance;
    }

    public void tryToSaveData(Orc hero) {
        boolean result = saveData(hero);
        if (result) {
            System.out.println("\nДанные сохранены!");
        } else {
            System.err.println("\nОшибка сохранения! Попробуйте позже.");
        }
    }

    public Orc tryToLoadData(String heroName) {
        Orc orc = extractData(heroName);
        if (orc != null) {
            System.out.println("\nДанные загружены!");
        } else {
            System.err.println("\nОшибка загрузки данных! Попробуйте позже.");
        }

        return orc;
    }

    private boolean saveData(Orc hero) {
        boolean result = false;
        if (hero != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_BASE_NAME))) {
                String packedHeroData = packHeroData(hero);
                writer.write(packedHeroData);
                writer.flush();
                result = true;
            } catch (IOException e) {
                System.err.println("Ошибка во время сохранения данных! " + e);
            }
        }

        return result;
    }

    private String packHeroData(Orc hero) {
        return (hero.getName() + DELIMITER + hero.getHealth() + DELIMITER + hero.getAttack() + DELIMITER + hero.getGold());
    }

    private Orc extractData(String heroName) {
        Orc orc = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_BASE_NAME))) {
            String heroData;
            while ((heroData = reader.readLine()) != null) {
                if (heroData.contains(heroName) && heroName.equals(getNameFromData(heroData))) {
                    orc = unpackHeroData(heroData);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении данных из базы! " + e);
        }

        return orc;
    }

    private Orc unpackHeroData(String heroData) {
        String[] stringData = heroData.split(DELIMITER);
        return new Orc(stringData[0],
                Integer.parseInt(stringData[1]), Integer.parseInt(stringData[2]), Long.parseLong(stringData[3]));
    }

    private String getNameFromData(String data) {
        return data.substring(0, data.indexOf(DELIMITER));
    }
}
