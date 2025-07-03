package com.example.zomboidcraft;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.DoubleValue infectionChance;
    public static final ForgeConfigSpec.DoubleValue bleedChance;
    public static final ForgeConfigSpec.IntValue infectionKillTime;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("general");
        infectionChance = builder.comment("Chance of infection from zombie attack").defineInRange("infectionChance", 0.3, 0.0, 1.0);
        bleedChance = builder.comment("Chance to start bleeding when damaged").defineInRange("bleedChance", 0.2, 0.0, 1.0);
        infectionKillTime = builder.comment("Ticks before infection kills player").defineInRange("infectionKillTime", 20 * 60, 20, 20 * 3600);
        builder.pop();
        SPEC = builder.build();
    }
}
