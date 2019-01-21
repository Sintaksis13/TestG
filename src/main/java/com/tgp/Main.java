package com.tgp;

import com.tgp.hero.Orc;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Orc orc = new Orc();
        while (true) {
            orc.toArena();
        }
    }
}
