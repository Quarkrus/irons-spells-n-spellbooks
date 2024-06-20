package io.redspace.ironsspellbooks.api.registry;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.spells.NoneSpell;
import io.redspace.ironsspellbooks.spells.blood.*;
import io.redspace.ironsspellbooks.spells.holy.*;
import io.redspace.ironsspellbooks.spells.ender.*;
import io.redspace.ironsspellbooks.spells.evocation.*;
import io.redspace.ironsspellbooks.spells.fire.*;
import io.redspace.ironsspellbooks.spells.ice.*;
import io.redspace.ironsspellbooks.spells.lightning.*;
import io.redspace.ironsspellbooks.spells.nature.*;
import io.redspace.ironsspellbooks.spells.eldritch.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SpellRegistry {
    public static final ResourceKey<Registry<AbstractSpell>> SPELL_REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(IronsSpellbooks.MODID, "spells"));
    private static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, IronsSpellbooks.MODID);
    public static final Supplier<IForgeRegistry<AbstractSpell>> REGISTRY = SPELLS.makeRegistry(() -> new RegistryBuilder<AbstractSpell>().disableSaving().disableOverrides());
    private static final NoneSpell noneSpell = new NoneSpell();
    private static final Map<SchoolType, List<AbstractSpell>> SCHOOLS_TO_SPELLS = new HashMap<>();
    public static void register(IEventBus eventBus) {
        SPELLS.register(eventBus);
    }

    public static NoneSpell none() {
        return noneSpell;
    }

    private static DeferredHolder<AbstractSpell, AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    public static AbstractSpell getSpell(String spellId) {
        return getSpell(new ResourceLocation(spellId));
    }

    public static List<AbstractSpell> getEnabledSpells() {
        return SpellRegistry.REGISTRY.get()
                .getValues()
                .stream()
                .filter(AbstractSpell::isEnabled)
                .toList();
    }

    public static List<AbstractSpell> getSpellsForSchool(SchoolType schoolType) {
        return SCHOOLS_TO_SPELLS.computeIfAbsent(schoolType, (school) -> SpellRegistry.REGISTRY.get()
                .getValues()
                .stream()
                .filter(spell -> spell.getSchoolType() == school).collect(Collectors.toList()));
    }

    public static AbstractSpell getSpell(ResourceLocation resourceLocation) {
        var spell = REGISTRY.get().getValue(resourceLocation);
        if (spell == null) {
            return noneSpell;
        }
        return spell;
    }

    public static void onConfigReload() {
        SCHOOLS_TO_SPELLS.clear();
    }

    //TODO: should the none spell be registered?

    // BLOOD
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ACUPUNCTURE_SPELL = registerSpell(new AcupunctureSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BLOOD_NEEDLES_SPELL = registerSpell(new BloodNeedlesSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BLOOD_SLASH_SPELL = registerSpell(new BloodSlashSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BLOOD_STEP_SPELL = registerSpell(new BloodStepSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> DEVOUR_SPELL = registerSpell(new DevourSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> HEARTSTOP_SPELL = registerSpell(new HeartstopSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> RAISE_DEAD_SPELL = registerSpell(new RaiseDeadSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> RAY_OF_SIPHONING_SPELL = registerSpell(new RayOfSiphoningSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> WITHER_SKULL_SPELL = registerSpell(new WitherSkullSpell());
    public static final RegistryObject<AbstractSpell> SACRIFICE_SPELL = registerSpell(new SacrificeSpell());

    // ENDER
    public static final DeferredHolder<AbstractSpell, AbstractSpell> COUNTERSPELL_SPELL = registerSpell(new CounterspellSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> DRAGON_BREATH_SPELL = registerSpell(new DragonBreathSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> EVASION_SPELL = registerSpell(new EvasionSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> MAGIC_ARROW_SPELL = registerSpell(new MagicArrowSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> MAGIC_MISSILE_SPELL = registerSpell(new MagicMissileSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> STARFALL_SPELL = registerSpell(new StarfallSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> TELEPORT_SPELL = registerSpell(new TeleportSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SUMMON_ENDER_CHEST_SPELL = registerSpell(new SummonEnderChestSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> RECALL_SPELL = registerSpell(new RecallSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> PORTAL_SPELL = registerSpell(new PortalSpell());
    public static final RegistryObject<AbstractSpell> ECHOING_STRIKES_SPELL = registerSpell(new EchoingStrikesSpell());
    public static final RegistryObject<AbstractSpell> BLACK_HOLE_SPELL = registerSpell(new BlackHoleSpell());

    // EVOCATION
    public static final DeferredHolder<AbstractSpell, AbstractSpell> CHAIN_CREEPER_SPELL = registerSpell(new ChainCreeperSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FANG_STRIKE_SPELL = registerSpell(new FangStrikeSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FANG_WARD_SPELL = registerSpell(new FangWardSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FIRECRACKER_SPELL = registerSpell(new FirecrackerSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> GUST_SPELL = registerSpell(new GustSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> INVISIBILITY_SPELL = registerSpell(new InvisibilitySpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> LOB_CREEPER_SPELL = registerSpell(new LobCreeperSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SHIELD_SPELL = registerSpell(new ShieldSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SPECTRAL_HAMMER_SPELL = registerSpell(new SpectralHammerSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SUMMON_HORSE_SPELL = registerSpell(new SummonHorseSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SUMMON_VEX_SPELL = registerSpell(new SummonVexSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SLOW_SPELL = registerSpell(new SlowSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ARROW_VOLLEY_SPELL = registerSpell(new ArrowVolleySpell());
    public static final RegistryObject<AbstractSpell> WOLOLO_SPELL = registerSpell(new WololoSpell());

    // FIRE
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BLAZE_STORM_SPELL = registerSpell(new BlazeStormSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BURNING_DASH_SPELL = registerSpell(new BurningDashSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FIREBALL_SPELL = registerSpell(new FireballSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FIREBOLT_SPELL = registerSpell(new FireboltSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FIRE_BREATH_SPELL = registerSpell(new FireBreathSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> MAGMA_BOMB_SPELL = registerSpell(new MagmaBombSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> WALL_OF_FIRE_SPELL = registerSpell(new WallOfFireSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> HEAT_SURGE_SPELL = registerSpell(new HeatSurgeSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FLAMING_STRIKE = registerSpell(new FlamingStrikeSpell());
    public static final RegistryObject<AbstractSpell> SCORCH_SPELL = registerSpell(new ScorchSpell());
    public static final RegistryObject<AbstractSpell> FLAMING_BARRAGE_SPELL = registerSpell(new FlamingBarrageSpell());

    // HOLY
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ANGEL_WINGS_SPELL = registerSpell(new AngelWingsSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BLESSING_OF_LIFE_SPELL = registerSpell(new BlessingOfLifeSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> CLOUD_OF_REGENERATION_SPELL = registerSpell(new CloudOfRegenerationSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FORTIFY_SPELL = registerSpell(new FortifySpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> GREATER_HEAL_SPELL = registerSpell(new GreaterHealSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> GUIDING_BOLT_SPELL = registerSpell(new GuidingBoltSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> HEALING_CIRCLE_SPELL = registerSpell(new HealingCircleSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> HEAL_SPELL = registerSpell(new HealSpell());
    //public static final DeferredHolder<AbstractSpell, AbstractSpell> SUNBEAM_SPELL = registerSpell(new SunbeamSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> WISP_SPELL = registerSpell(new WispSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> DIVINE_SMITE_SPELL = registerSpell(new DivineSmiteSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> HASTE_SPELL = registerSpell(new HasteSpell());

    // ICE
    public static final DeferredHolder<AbstractSpell, AbstractSpell> CONE_OF_COLD_SPELL = registerSpell(new ConeOfColdSpell());
    //    public static final DeferredHolder<AbstractSpell, AbstractSpell> FROSTBITE_SPELL = registerSpell(new FrostbiteSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FROST_STEP_SPELL = registerSpell(new FrostStepSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ICE_BLOCK_SPELL = registerSpell(new IceBlockSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ICICLE_SPELL = registerSpell(new IcicleSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SUMMON_POLAR_BEAR_SPELL = registerSpell(new SummonPolarBearSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> RAY_OF_FROST_SPELL = registerSpell(new RayOfFrostSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FROSTWAVE_SPELL = registerSpell(new FrostwaveSpell());

    // LIGHTNING
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ASCENSION_SPELL = registerSpell(new AscensionSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> CHAIN_LIGHTNING_SPELL = registerSpell(new ChainLightningSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> CHARGE_SPELL = registerSpell(new ChargeSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ELECTROCUTE_SPELL = registerSpell(new ElectrocuteSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> LIGHTNING_BOLT_SPELL = registerSpell(new LightningBoltSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> LIGHTNING_LANCE_SPELL = registerSpell(new LightningLanceSpell());
    //public static final DeferredHolder<AbstractSpell, AbstractSpell> THUNDER_STEP_SPELL = registerSpell(new ThunderStepSpell());
    public static final RegistryObject<AbstractSpell> SHOCKWAVE_SPELL = registerSpell(new ShockwaveSpell());
    public static final RegistryObject<AbstractSpell> THUNDERSTORM_SPELL = registerSpell(new ThunderstormSpell());
    public static final RegistryObject<AbstractSpell> BALL_LIGHTNING_SPELL = registerSpell(new BallLightningSpell());

    // NATURE
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ACID_ORB_SPELL = registerSpell(new AcidOrbSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> BLIGHT_SPELL = registerSpell(new BlightSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> POISON_ARROW_SPELL = registerSpell(new PoisonArrowSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> POISON_BREATH_SPELL = registerSpell(new PoisonBreathSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> POISON_SPLASH_SPELL = registerSpell(new PoisonSplashSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ROOT_SPELL = registerSpell(new RootSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SPIDER_ASPECT_SPELL = registerSpell(new SpiderAspectSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> FIREFLY_SWARM_SPELL = registerSpell(new FireflySwarmSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> OAKSKIN_SPELL = registerSpell(new OakskinSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> EARTHQUAKE_SPELL = registerSpell(new EarthquakeSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> STOMP_SPELL = registerSpell(new StompSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> GLUTTONY_SPELL = registerSpell(new GluttonySpell());

    //VOID
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ABYSSAL_SHROUD_SPELL = registerSpell(new AbyssalShroudSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SCULK_TENTACLES_SPELL = registerSpell(new SculkTentaclesSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> SONIC_BOOM_SPELL = registerSpell(new SonicBoomSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> PLANAR_SIGHT_SPELL = registerSpell(new PlanarSightSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> TELEKINESIS_SPELL = registerSpell(new TelekinesisSpell());
    public static final DeferredHolder<AbstractSpell, AbstractSpell> ELDRITCH_BLAST_SPELL = registerSpell(new EldritchBlastSpell());
}
