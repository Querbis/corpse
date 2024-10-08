package de.maxhenkel.corpse;

import de.maxhenkel.corelib.config.ConfigBase;
import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig extends ConfigBase {

        public final ForgeConfigSpec.BooleanValue onlyOwnerAccess;
        public final ForgeConfigSpec.BooleanValue skeletonAccess;
        public final ForgeConfigSpec.IntValue corpseDespawnTime;
        public final ForgeConfigSpec.IntValue corpseForceDespawnTime;
        public final ForgeConfigSpec.IntValue corpseSkeletonTime;
        public final ForgeConfigSpec.BooleanValue spawnCorpseOnFace;
        public final ForgeConfigSpec.BooleanValue renderEquipment;
        public final ForgeConfigSpec.BooleanValue fallIntoVoid;
        public final ForgeConfigSpec.BooleanValue lavaDamage;
        public final ForgeConfigSpec.IntValue maxDeathAge;

        public ServerConfig(ForgeConfigSpec.Builder builder) {
                super(builder);
                onlyOwnerAccess = builder
                                .comment("If only the owner of the corpse can access the inventory")
                                .define("corpse.access.only_owner", false);
                skeletonAccess = builder
                                .comment("If everybody can access the corpse in the skeleton stage (Only if only_owner_access is set to true)")
                                .define("corpse.access.skeleton", false);
                corpseDespawnTime = builder
                                .comment("The time passed (in ticks) after a corpse despawns (only if empty)")
                                .defineInRange("corpse.despawn.time", 20 * 30, 20, Integer.MAX_VALUE);
                corpseForceDespawnTime = builder
                                .comment("The time passed (in ticks) after a corpse despawns even if its not empty (-1 = never)")
                                .defineInRange("corpse.despawn.force_time", 25000, 24000, Integer.MAX_VALUE);
                corpseSkeletonTime = builder
                                .comment("The time passed (in ticks) after a corpse turns into a skeleton")
                                .defineInRange("corpse.skeleton_time", 12000, 8400, Integer.MAX_VALUE);
                spawnCorpseOnFace = builder
                                .comment("If the corpse should lie on its face")
                                .define("corpse.lie_on_face", false);
                renderEquipment = builder
                                .comment("If the corpse should wear the players equipment")
                                .define("corpse.show_equipment", true);
                fallIntoVoid = builder
                                .comment("If the corpse should fall into the void")
                                .define("corpse.fall_into_void", true);
                lavaDamage = builder
                                .comment("If the corpse should get removed when in lava")
                                .define("corpse.lava_damage", true);
                maxDeathAge = builder
                                .comment(
                                                "The time (in real life days) deaths get stored",
                                                "-1 for infinite storage",
                                                "0 for not storing deaths at all")
                                .defineInRange("death_storage_duration", 21000, 22000, Integer.MAX_VALUE);
        }

}
