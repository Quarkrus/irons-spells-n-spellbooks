package io.redspace.ironsspellbooks.registries;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.particle.*;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, IronsSpellbooks.MODID);

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    /*
    To Create Particle:
    - textures + json
    - particle class
    - register it here
    - add it to particle helper
    - register it in client setup
     */

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_PARTICLE = PARTICLE_TYPES.register("blood", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WISP_PARTICLE = PARTICLE_TYPES.register("wisp", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_GROUND_PARTICLE = PARTICLE_TYPES.register("blood_ground", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SNOWFLAKE_PARTICLE = PARTICLE_TYPES.register("snowflake", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ELECTRICITY_PARTICLE = PARTICLE_TYPES.register("electricity", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> UNSTABLE_ENDER_PARTICLE = PARTICLE_TYPES.register("unstable_ender", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DRAGON_FIRE_PARTICLE = PARTICLE_TYPES.register("dragon_fire", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIRE_PARTICLE = PARTICLE_TYPES.register("fire", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EMBER_PARTICLE = PARTICLE_TYPES.register("embers", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SIPHON_PARTICLE = PARTICLE_TYPES.register("spell", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ACID_PARTICLE = PARTICLE_TYPES.register("acid", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ACID_BUBBLE_PARTICLE = PARTICLE_TYPES.register("acid_bubble", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RING_SMOKE_PARTICLE = PARTICLE_TYPES.register("ring_smoke", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, ParticleType<FogParticleOptions>> FOG_PARTICLE = PARTICLE_TYPES.register("fog", () -> new ParticleType<FogParticleOptions>(true, FogParticleOptions.DESERIALIZER) {
        public Codec<FogParticleOptions> codec() {
            return FogParticleOptions.CODEC;
        }
    });
    public static final DeferredHolder<ParticleType<?>, ParticleType<ShockwaveParticleOptions>> SHOCKWAVE_PARTICLE = PARTICLE_TYPES.register("shockwave", () -> new ParticleType<>(false, ShockwaveParticleOptions.DESERIALIZER) {
        public Codec<ShockwaveParticleOptions> codec() {
            return ShockwaveParticleOptions.CODEC;
        }
    });
    public static final DeferredHolder<ParticleType<?>, ParticleType<ZapParticleOption>> ZAP_PARTICLE = PARTICLE_TYPES.register("zap", () -> new ParticleType<ZapParticleOption>(false, ZapParticleOption.DESERIALIZER) {
        public Codec<ZapParticleOption> codec() {
            return ZapParticleOption.CODEC;
        }
    });
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLY_PARTICLE = PARTICLE_TYPES.register("firefly", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PORTAL_FRAME_PARTICLE = PARTICLE_TYPES.register("portal_frame", () -> new SimpleParticleType(false));
    //fixme: 3.2.0 rebase
    public static final RegistryObject<SimpleParticleType> SNOW_DUST = PARTICLE_TYPES.register("snow_dust", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<BlastwaveParticleOptions>> BLASTWAVE_PARTICLE = PARTICLE_TYPES.register("blastwave", () -> new ParticleType<BlastwaveParticleOptions>(true, BlastwaveParticleOptions.DESERIALIZER) {
        public Codec<BlastwaveParticleOptions> codec() {
            return BlastwaveParticleOptions.CODEC;
        }
    });
    public static final RegistryObject<ParticleType<SparkParticleOptions>> SPARK_PARTICLE = PARTICLE_TYPES.register("spark", () -> new ParticleType<SparkParticleOptions>(true, SparkParticleOptions.DESERIALIZER) {
        public Codec<SparkParticleOptions> codec() {
            return SparkParticleOptions.CODEC;
        }
    });
}
