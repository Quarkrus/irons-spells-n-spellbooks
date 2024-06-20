package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.*;
import io.redspace.ironsspellbooks.item.armor.*;
import io.redspace.ironsspellbooks.item.consumables.FireAleItem;
import io.redspace.ironsspellbooks.item.consumables.NetherwardTinctureItem;
import io.redspace.ironsspellbooks.item.consumables.SimpleElixir;
import io.redspace.ironsspellbooks.item.curios.*;
import io.redspace.ironsspellbooks.item.spell_books.SimpleAttributeSpellBook;
import io.redspace.ironsspellbooks.item.weapons.*;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IronsSpellbooks.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //public static final DeferredHolder<Item, Item> SPELL_BOOK = ITEMS.register("spell_book", SpellBook::new);
    /**
     * Spell items
     */
    public static final DeferredHolder<Item, Item> WIMPY_SPELL_BOOK = ITEMS.register("wimpy_spell_book", () -> new SpellBook(0, SpellRarity.LEGENDARY, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> LEGENDARY_SPELL_BOOK = ITEMS.register("legendary_spell_book", () -> new SpellBook(12, SpellRarity.LEGENDARY, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> NETHERITE_SPELL_BOOK = ITEMS.register("netherite_spell_book", () -> new SimpleAttributeSpellBook(12, SpellRarity.LEGENDARY, AttributeRegistry.COOLDOWN_REDUCTION.get(), .20));
    public static final DeferredHolder<Item, Item> DIAMOND_SPELL_BOOK = ITEMS.register("diamond_spell_book", () -> new SpellBook(10, SpellRarity.EPIC));
    public static final DeferredHolder<Item, Item> GOLD_SPELL_BOOK = ITEMS.register("gold_spell_book", () -> new SimpleAttributeSpellBook(8, SpellRarity.RARE, AttributeRegistry.CAST_TIME_REDUCTION.get(), .15));
    public static final DeferredHolder<Item, Item> IRON_SPELL_BOOK = ITEMS.register("iron_spell_book", () -> new SpellBook(6, SpellRarity.UNCOMMON));
    public static final DeferredHolder<Item, Item> COPPER_SPELL_BOOK = ITEMS.register("copper_spell_book", () -> new SpellBook(5, SpellRarity.COMMON));
    public static final DeferredHolder<Item, Item> ROTTEN_SPELL_BOOK = ITEMS.register("rotten_spell_book", () -> new SimpleAttributeSpellBook(8, SpellRarity.RARE, AttributeRegistry.SPELL_RESIST.get(), -.15));
    public static final DeferredHolder<Item, Item> BLAZE_SPELL_BOOK = ITEMS.register("blaze_spell_book", () -> new SimpleAttributeSpellBook(10, SpellRarity.LEGENDARY, AttributeRegistry.FIRE_SPELL_POWER.get(), .10));
    public static final DeferredHolder<Item, Item> DRAGONSKIN_SPELL_BOOK = ITEMS.register("dragonskin_spell_book", () -> new SimpleAttributeSpellBook(12, SpellRarity.LEGENDARY, AttributeRegistry.ENDER_SPELL_POWER.get(), .10));
    public static final DeferredHolder<Item, Item> DRUIDIC_SPELL_BOOK = ITEMS.register("druidic_spell_book", () -> new SimpleAttributeSpellBook(10, SpellRarity.LEGENDARY, AttributeRegistry.NATURE_SPELL_POWER.get(), .10));
    public static final DeferredHolder<Item, Item> VILLAGER_SPELL_BOOK = ITEMS.register("villager_spell_book", () -> {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(AttributeRegistry.HOLY_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .08, AttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .08, AttributeModifier.Operation.MULTIPLY_BASE));
        return new SimpleAttributeSpellBook(10, SpellRarity.LEGENDARY, builder.build());
    });
    public static final DeferredHolder<Item, Item> GRAYBEARD_STAFF = ITEMS.register("graybeard_staff", () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1), 2, -3, Map.of(AttributeRegistry.MANA_REGEN.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .25, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .10, AttributeModifier.Operation.MULTIPLY_BASE))));
    public static final DeferredHolder<Item, Item> ARTIFICER_STAFF = ITEMS.register("artificer_cane", () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1), 3, -3, Map.of(AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .15, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .15, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .10, AttributeModifier.Operation.MULTIPLY_BASE))));
    public static final DeferredHolder<Item, Item> ICE_STAFF = ITEMS.register("ice_staff", () -> new StaffItem(ItemPropertiesHelper.equipment(1).rarity(Rarity.RARE), 3, -3, Map.of(AttributeRegistry.MANA_REGEN.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .25, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .15, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .05, AttributeModifier.Operation.MULTIPLY_BASE))));
    //fixme: 3.2.0 rebase
    public static final RegistryObject<Item> LIGHTNING_ROD_STAFF = ITEMS.register("lightning_rod", () -> new StaffItem(ItemPropertiesHelper.equipment(1).rarity(Rarity.UNCOMMON).fireResistant(), 4, -3, Map.of(AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .15, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .15, AttributeModifier.Operation.MULTIPLY_BASE), AttributeRegistry.SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .05, AttributeModifier.Operation.MULTIPLY_BASE))));

    public static final DeferredHolder<Item, Item> BLOOD_STAFF = ITEMS.register("blood_staff", BloodStaffItem::new);

    public static final DeferredHolder<Item, Item> EVOKER_SPELL_BOOK = ITEMS.register("evoker_spell_book", () -> new UniqueSpellBook(SpellRarity.LEGENDARY,
            new SpellDataRegistryHolder[]{
                    new SpellDataRegistryHolder(SpellRegistry.FANG_STRIKE_SPELL, 6),
                    new SpellDataRegistryHolder(SpellRegistry.FANG_WARD_SPELL, 4),
                    new SpellDataRegistryHolder(SpellRegistry.SUMMON_VEX_SPELL, 4)},
            7,
            () -> {
                ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
                builder.put(AttributeRegistry.EVOCATION_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .10, AttributeModifier.Operation.MULTIPLY_BASE));
                return builder.build();
            })
    );
    public static final DeferredHolder<Item, Item> NECRONOMICON = ITEMS.register("necronomicon_spell_book", NecronomiconSpellBook::new);

    public static final DeferredHolder<Item, Item> MAGEHUNTER = ITEMS.register("magehunter", MagehunterItem::new);
    public static final DeferredHolder<Item, Item> SPELLBREAKER = ITEMS.register("spellbreaker", () -> new SpellbreakerItem(SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.COUNTERSPELL_SPELL, 1))));
    public static final DeferredHolder<Item, Item> TEST_CLAYMORE = ITEMS.register("claymore", TestClaymoreItem::new);
    public static final DeferredHolder<Item, Item> KEEPER_FLAMBERGE = ITEMS.register("keeper_flamberge", KeeperFlambergeItem::new);
    //fixme: 3.2.0 rebase
    public static final RegistryObject<Item> AMETHYST_RAPIER = ITEMS.register("amethyst_rapier", () -> new AmethystRapierItem(SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.ECHOING_STRIKES_SPELL, 5))));
    public static final RegistryObject<Item> MISERY = ITEMS.register("misery", () -> new MagicSwordItem(ExtendedWeaponTiers.DREADSWORD, 7, -2.1, SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.WITHER_SKULL_SPELL, 8)), Map.of(), ItemPropertiesHelper.hidden(1)));
    //    public static final RegistryObject<Item> TRUTHSEEKER = ITEMS.register("truthseeker", TruthseekerItem::new);
//    public static final RegistryObject<Item> DREADSWORD = ITEMS.register("dreadsword", () -> new MagicSwordItem(ExtendedWeaponTiers.DREADSWORD, 6, -2.4, SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.WITHER_SKULL_SPELL, 1)), Map.of(), ItemPropertiesHelper.equipment(1)));
    //public static final RegistryObject<Item> FIREBRAND = ITEMS.register("firebrand", FirebrandItem::new);
    public static final DeferredHolder<Item, Item> SCROLL = ITEMS.register("scroll", Scroll::new);
    public static final DeferredHolder<Item, Item> AUTOLOADER_CROSSBOW = ITEMS.register("autoloader_crossbow", () -> new AutoloaderCrossbow(ItemPropertiesHelper.hidden(1).durability(465)));
    public static final DeferredHolder<Item, Item> HITHER_THITHER_WAND = ITEMS.register("hither_thither_wand", () -> new HitherThitherWand(ItemPropertiesHelper.equipment(1).rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> STAFF_OF_THE_NINES = ITEMS.register("staff_of_the_nines", () -> new StaffOfTheNines(ItemPropertiesHelper.hidden(1).rarity(Rarity.EPIC)));
    /**
     * Ink
     */
    public static final DeferredHolder<Item, Item> INK_COMMON = ITEMS.register("common_ink", () -> new InkItem(SpellRarity.COMMON));
    public static final DeferredHolder<Item, Item> INK_UNCOMMON = ITEMS.register("uncommon_ink", () -> new InkItem(SpellRarity.UNCOMMON));
    public static final DeferredHolder<Item, Item> INK_RARE = ITEMS.register("rare_ink", () -> new InkItem(SpellRarity.RARE));
    public static final DeferredHolder<Item, Item> INK_EPIC = ITEMS.register("epic_ink", () -> new InkItem(SpellRarity.EPIC));
    public static final DeferredHolder<Item, Item> INK_LEGENDARY = ITEMS.register("legendary_ink", () -> new InkItem(SpellRarity.LEGENDARY));

    /**
     * Potions
     */
//    public static final DeferredHolder<Item, Item> CASTERS_TEA = ITEMS.register("casters_tea", () -> new CastersTea(ItemPropertiesHelper.material().stacksTo(4)));
    public static final DeferredHolder<Item, Item> OAKSKIN_ELIXIR = ITEMS.register("oakskin_elixir", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffectRegistry.OAKSKIN.get(), 900, 1)));
    public static final DeferredHolder<Item, Item> GREATER_OAKSKIN_ELIXIR = ITEMS.register("greater_oakskin_elixir", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffectRegistry.OAKSKIN.get(), 1800, 3), true));
    public static final DeferredHolder<Item, Item> GREATER_HEALING_POTION = ITEMS.register("greater_healing_potion", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffects.HEAL, 1, 2)));
    public static final DeferredHolder<Item, Item> INVISIBILITY_ELIXIR = ITEMS.register("invisibility_elixir", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffectRegistry.TRUE_INVISIBILITY.get(), 20 * 15, 0, false, false, true)));
    public static final DeferredHolder<Item, Item> GREATER_INVISIBILITY_ELIXIR = ITEMS.register("greater_invisibility_elixir", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffectRegistry.TRUE_INVISIBILITY.get(), 20 * 40, 0, false, false, true), true));
    public static final DeferredHolder<Item, Item> EVASION_ELIXIR = ITEMS.register("evasion_elixir", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffectRegistry.EVASION.get(), 20 * 60, 1, false, false, true)));
    public static final DeferredHolder<Item, Item> GREATER_EVASION_ELIXIR = ITEMS.register("greater_evasion_elixir", () -> new SimpleElixir(ItemPropertiesHelper.material(), () -> new MobEffectInstance(MobEffectRegistry.EVASION.get(), 20 * 60, 3, false, false, true), true));
    //fixme: 3.2.0 rebase
    public static final RegistryObject<Item> FIRE_ALE = ITEMS.register("fire_ale", () -> new FireAleItem(ItemPropertiesHelper.material()));
    public static final RegistryObject<Item> NETHERWARD_TINCTURE = ITEMS.register("netherward_tincture", NetherwardTinctureItem::new);

    /**
     * Upgrade Orbs
     */
    public static final DeferredHolder<Item, Item> UPGRADE_ORB = ITEMS.register("upgrade_orb", () -> new Item(ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> FIRE_UPGRADE_ORB = ITEMS.register("fire_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.FIRE_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> ICE_UPGRADE_ORB = ITEMS.register("ice_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.ICE_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> LIGHTNING_UPGRADE_ORB = ITEMS.register("lightning_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.LIGHTNING_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> HOLY_UPGRADE_ORB = ITEMS.register("holy_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.HOLY_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> ENDER_UPGRADE_ORB = ITEMS.register("ender_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.ENDER_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> BLOOD_UPGRADE_ORB = ITEMS.register("blood_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.BLOOD_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> EVOCATION_UPGRADE_ORB = ITEMS.register("evocation_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.EVOCATION_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> NATURE_UPGRADE_ORB = ITEMS.register("nature_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.NATURE_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> MANA_UPGRADE_ORB = ITEMS.register("mana_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.MANA, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> COOLDOWN_UPGRADE_ORB = ITEMS.register("cooldown_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.COOLDOWN, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> PROTECTION_UPGRADE_ORB = ITEMS.register("protection_upgrade_orb", () -> new UpgradeOrbItem(UpgradeTypes.SPELL_RESISTANCE, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));

    /**
     * Generic Items
     */
    public static final DeferredHolder<Item, Item> LIGHTNING_BOTTLE = ITEMS.register("lightning_bottle", () -> new Item(ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> FROZEN_BONE_SHARD = ITEMS.register("frozen_bone", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> BLOOD_VIAL = ITEMS.register("blood_vial", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> DIVINE_PEARL = ITEMS.register("divine_pearl", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> FURLED_MAP = ITEMS.register("furled_map", () -> new FurledMapItem());
    public static final DeferredHolder<Item, Item> HOGSKIN = ITEMS.register("hogskin", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> DRAGONSKIN = ITEMS.register("dragonskin", DragonskinItem::new);
    public static final DeferredHolder<Item, Item> ARCANE_ESSENCE = ITEMS.register("arcane_essence", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> MAGIC_CLOTH = ITEMS.register("magic_cloth", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> BLANK_RUNE = ITEMS.register("blank_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> FIRE_RUNE = ITEMS.register("fire_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> ICE_RUNE = ITEMS.register("ice_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> LIGHTNING_RUNE = ITEMS.register("lightning_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> ENDER_RUNE = ITEMS.register("ender_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> HOLY_RUNE = ITEMS.register("holy_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> BLOOD_RUNE = ITEMS.register("blood_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> EVOCATION_RUNE = ITEMS.register("evocation_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> MANA_RUNE = ITEMS.register("arcane_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> COOLDOWN_RUNE = ITEMS.register("cooldown_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> PROTECTION_RUNE = ITEMS.register("protection_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> NATURE_RUNE = ITEMS.register("nature_rune", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> WAYWARD_COMPASS = ITEMS.register("wayward_compass", WaywardCompass::new);
    public static final DeferredHolder<Item, Item> RUINED_BOOK = ITEMS.register("ruined_book", () -> new Item(ItemPropertiesHelper.material().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> CINDER_ESSENCE = ITEMS.register("cinder_essence", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> ARCANE_SALVAGE = ITEMS.register("arcane_salvage", ArcaneSalvageItem::new);
    public static final DeferredHolder<Item, Item> ARCANE_INGOT = ITEMS.register("arcane_ingot", () -> new Item(ItemPropertiesHelper.material()));
    public static final DeferredHolder<Item, Item> SHRIVING_STONE = ITEMS.register("shriving_stone", ShrivingStoneItem::new);
    public static final DeferredHolder<Item, Item> ELDRITCH_PAGE = ITEMS.register("eldritch_manuscript", () -> new EldritchManuscript(ItemPropertiesHelper.material().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> LOST_KNOWLEDGE_FRAGMENT = ITEMS.register("ancient_knowledge_fragment", () -> new Item(ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> FROSTED_HELVE = ITEMS.register("frosted_helve", () -> new Item(ItemPropertiesHelper.material().rarity(Rarity.COMMON)));
    public static final DeferredHolder<Item, Item> ICE_CRYSTAL = ITEMS.register("permafrost_shard", () -> new Item(ItemPropertiesHelper.material().rarity(Rarity.RARE)));
    //fixme: 3.2.0 rebase
    public static final RegistryObject<Item> ENERGIZED_CORE = ITEMS.register("energized_core", () -> new EnergizedCoreItem(ItemPropertiesHelper.material(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LESSER_SPELL_SLOT_UPGRADE = ITEMS.register("lesser_spell_slot_upgrade", () -> new SpellSlotUpgradeItem(12));

    /**
     * Block Items
     */
    public static final DeferredHolder<Item, Item> INSCRIPTION_TABLE_BLOCK_ITEM = ITEMS.register("inscription_table", () -> new BlockItem(BlockRegistry.INSCRIPTION_TABLE_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> ACANE_ANVIL_BLOCK_ITEM = ITEMS.register("arcane_anvil", () -> new BlockItem(BlockRegistry.ARCANE_ANVIL_BLOCK.get(), new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> SCROLL_FORGE_BLOCK = ITEMS.register("scroll_forge", () -> new BlockItem(BlockRegistry.SCROLL_FORGE_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> PEDESTAL_BLOCK_ITEM = ITEMS.register("pedestal", () -> new BlockItem(BlockRegistry.PEDESTAL_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> ARMOR_PILE_BLOCK_ITEM = ITEMS.register("armor_pile", () -> new BlockItem(BlockRegistry.ARMOR_PILE_BLOCK.get(), new Item.Properties()));
    //public static final DeferredHolder<Item, Item> BLOOD_SLASH_BLOCK_ITEM = ITEMS.register("blood_slash_block", () -> new BlockItem(BlockRegistry.BLOOD_SLASH_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final DeferredHolder<Item, Item> ARCANE_DEBRIS_BLOCK_ITEM = ITEMS.register("arcane_debris", () -> new BlockItem(BlockRegistry.ARCANE_DEBRIS.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> ALCHEMIST_CAULDRON_BLOCK_ITEM = ITEMS.register("alchemist_cauldron", () -> new BlockItem(BlockRegistry.ALCHEMIST_CAULDRON.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> FIREFLY_JAR_ITEM = ITEMS.register("firefly_jar", () -> new BlockItem(BlockRegistry.FIREFLY_JAR.get(), new Item.Properties()));

    /**
     * Armor
     */
//    public static final DeferredHolder<Item, Item> WIZARD_HAT = ITEMS.register("wizard_hat", () -> new WizardArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
//    public static final DeferredHolder<Item, Item> WIZARD_ROBE = ITEMS.register("wizard_robe", () -> new WizardArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
//    public static final DeferredHolder<Item, Item> WIZARD_PANTS = ITEMS.register("wizard_pants", () -> new WizardArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
//    public static final DeferredHolder<Item, Item> WIZARD_BOOTS = ITEMS.register("wizard_boots", () -> new WizardArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> WANDERING_MAGICIAN_HELMET = ITEMS.register("wandering_magician_helmet", () -> new WanderingMagicianArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> WANDERING_MAGICIAN_CHESTPLATE = ITEMS.register("wandering_magician_chestplate", () -> new WanderingMagicianArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> WANDERING_MAGICIAN_LEGGINGS = ITEMS.register("wandering_magician_leggings", () -> new WanderingMagicianArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> WANDERING_MAGICIAN_BOOTS = ITEMS.register("wandering_magician_boots", () -> new WanderingMagicianArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> PUMPKIN_HELMET = ITEMS.register("pumpkin_helmet", () -> new PumpkinArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PUMPKIN_CHESTPLATE = ITEMS.register("pumpkin_chestplate", () -> new PumpkinArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PUMPKIN_LEGGINGS = ITEMS.register("pumpkin_leggings", () -> new PumpkinArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PUMPKIN_BOOTS = ITEMS.register("pumpkin_boots", () -> new PumpkinArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> PYROMANCER_HELMET = ITEMS.register("pyromancer_helmet", () -> new PyromancerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PYROMANCER_CHESTPLATE = ITEMS.register("pyromancer_chestplate", () -> new PyromancerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PYROMANCER_LEGGINGS = ITEMS.register("pyromancer_leggings", () -> new PyromancerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PYROMANCER_BOOTS = ITEMS.register("pyromancer_boots", () -> new PyromancerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> ELECTROMANCER_HELMET = ITEMS.register("electromancer_helmet", () -> new ElectromancerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> ELECTROMANCER_CHESTPLATE = ITEMS.register("electromancer_chestplate", () -> new ElectromancerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> ELECTROMANCER_LEGGINGS = ITEMS.register("electromancer_leggings", () -> new ElectromancerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> ELECTROMANCER_BOOTS = ITEMS.register("electromancer_boots", () -> new ElectromancerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> ARCHEVOKER_HELMET = ITEMS.register("archevoker_helmet", () -> new ArchevokerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> ARCHEVOKER_CHESTPLATE = ITEMS.register("archevoker_chestplate", () -> new ArchevokerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> ARCHEVOKER_LEGGINGS = ITEMS.register("archevoker_leggings", () -> new ArchevokerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> ARCHEVOKER_BOOTS = ITEMS.register("archevoker_boots", () -> new ArchevokerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> CULTIST_HELMET = ITEMS.register("cultist_helmet", () -> new CultistArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> CULTIST_CHESTPLATE = ITEMS.register("cultist_chestplate", () -> new CultistArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> CULTIST_LEGGINGS = ITEMS.register("cultist_leggings", () -> new CultistArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> CULTIST_BOOTS = ITEMS.register("cultist_boots", () -> new CultistArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> CRYOMANCER_HELMET = ITEMS.register("cryomancer_helmet", () -> new CryomancerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> CRYOMANCER_CHESTPLATE = ITEMS.register("cryomancer_chestplate", () -> new CryomancerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> CRYOMANCER_LEGGINGS = ITEMS.register("cryomancer_leggings", () -> new CryomancerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> CRYOMANCER_BOOTS = ITEMS.register("cryomancer_boots", () -> new CryomancerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> SHADOWWALKER_HELMET = ITEMS.register("shadowwalker_helmet", () -> new ShadowwalkerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> SHADOWWALKER_CHESTPLATE = ITEMS.register("shadowwalker_chestplate", () -> new ShadowwalkerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> SHADOWWALKER_LEGGINGS = ITEMS.register("shadowwalker_leggings", () -> new ShadowwalkerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> SHADOWWALKER_BOOTS = ITEMS.register("shadowwalker_boots", () -> new ShadowwalkerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> PRIEST_HELMET = ITEMS.register("priest_helmet", () -> new PriestArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PRIEST_CHESTPLATE = ITEMS.register("priest_chestplate", () -> new PriestArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PRIEST_LEGGINGS = ITEMS.register("priest_leggings", () -> new PriestArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PRIEST_BOOTS = ITEMS.register("priest_boots", () -> new PriestArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> PLAGUED_HELMET = ITEMS.register("plagued_helmet", () -> new PlaguedArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PLAGUED_CHESTPLATE = ITEMS.register("plagued_chestplate", () -> new PlaguedArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PLAGUED_LEGGINGS = ITEMS.register("plagued_leggings", () -> new PlaguedArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final DeferredHolder<Item, Item> PLAGUED_BOOTS = ITEMS.register("plagued_boots", () -> new PlaguedArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final DeferredHolder<Item, Item> NETHERITE_MAGE_HELMET = ITEMS.register("netherite_mage_helmet", () -> new NetheriteMageArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant()));
    public static final DeferredHolder<Item, Item> NETHERITE_MAGE_CHESTPLATE = ITEMS.register("netherite_mage_chestplate", () -> new NetheriteMageArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment().fireResistant()));
    public static final DeferredHolder<Item, Item> NETHERITE_MAGE_LEGGINGS = ITEMS.register("netherite_mage_leggings", () -> new NetheriteMageArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment().fireResistant()));
    public static final DeferredHolder<Item, Item> NETHERITE_MAGE_BOOTS = ITEMS.register("netherite_mage_boots", () -> new NetheriteMageArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment().fireResistant()));

    public static final DeferredHolder<Item, Item> TARNISHED_CROWN = ITEMS.register("tarnished_helmet", () -> new TarnishedCrownArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item, Item> DEV_CROWN = ITEMS.register("gold_crown", () -> new GoldCrownArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.hidden(1).rarity(Rarity.EPIC)));

    /**
     * Curios
     */
    //public static final DeferredHolder<EntityType<?>, CurioBaseItem> ENCHANTED_WARD_AMULET = ITEMS.register("enchanted_ward_amulet", EnchantedWardAmulet::new);
    public static final DeferredHolder<Item, SimpleAttributeCurio> MANA_RING = ITEMS.register("mana_ring", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 100, AttributeModifier.Operation.ADDITION)));
    public static final DeferredHolder<Item, SimpleAttributeCurio> SILVER_RING = ITEMS.register("silver_ring", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 25, AttributeModifier.Operation.ADDITION)));
    public static final DeferredHolder<Item, SimpleAttributeCurio> COOLDOWN_RING = ITEMS.register("cooldown_ring", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("cd", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final DeferredHolder<Item, SimpleAttributeCurio> CAST_TIME_RING = ITEMS.register("cast_time_ring", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("ct", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final DeferredHolder<Item, SimpleAttributeCurio> HEAVY_CHAIN = ITEMS.register("heavy_chain_necklace", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.SPELL_RESIST.get(), new AttributeModifier("spell resist", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final DeferredHolder<Item, SimpleDescriptiveCurio> EMERALD_STONEPLATE_RING = ITEMS.register("emerald_stoneplate_ring", () -> new SimpleDescriptiveCurio(ItemPropertiesHelper.equipment().stacksTo(1), Curios.RING_SLOT));
    public static final DeferredHolder<Item, CurioBaseItem> FIREWARD_RING = ITEMS.register("fireward_ring", FirewardRing::new);
    public static final DeferredHolder<Item, CurioBaseItem> FROSTWARD_RING = ITEMS.register("frostward_ring", FrostwardRing::new);
    public static final DeferredHolder<Item, CurioBaseItem> POISONWARD_RING = ITEMS.register("poisonward_ring", PoisonwardRing::new);
    public static final DeferredHolder<Item, CurioBaseItem> CONJURERS_TALISMAN = ITEMS.register("conjurers_talisman", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.SUMMON_DAMAGE.get(), new AttributeModifier("summon", 0.10, AttributeModifier.Operation.MULTIPLY_BASE)));
    public static final DeferredHolder<Item, CurioBaseItem> AFFINITY_RING = ITEMS.register("affinity_ring", () -> new AffinityRing(ItemPropertiesHelper.equipment().stacksTo(1)));
    public static final DeferredHolder<Item, CurioBaseItem> CONCENTRATION_AMULET = ITEMS.register("concentration_amulet", () -> new SimpleDescriptiveCurio(ItemPropertiesHelper.equipment().stacksTo(1), Curios.NECKLACE_SLOT));
    public static final DeferredHolder<Item, CurioBaseItem> LURKER_RING = ITEMS.register("lurker_ring", LurkerRing::new);
    public static final DeferredHolder<Item, CurioBaseItem> AMETHYST_RESONANCE_NECKLACE = ITEMS.register("amethyst_resonance_charm", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("mana_regen", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)));

    //leave invis ring at the bottom so you can't see a gap in the creative inventory
    public static final DeferredHolder<Item, CurioBaseItem> INVISIBILITY_RING = ITEMS.register("invisibility_ring", InvisibiltyRing::new);

    /**
     * Spawn eggs
     */
    public static final DeferredHolder<Item, DeferredSpawnEggItem> KEEPER_SPAWN_EGG = ITEMS.register("keeper_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.KEEPER, 0x352d2d, 0x766a76, ItemPropertiesHelper.material().stacksTo(64)));
    public static final DeferredHolder<Item, DeferredSpawnEggItem> DEAD_KING_CORPSE_SPAWN_EGG = ITEMS.register("dead_king_corpse_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.DEAD_KING_CORPSE, 6842447, 15066584, ItemPropertiesHelper.material().stacksTo(64)));
    public static final DeferredHolder<Item, DeferredSpawnEggItem> ARCHEVOKER_SPAWN_EGG = ITEMS.register("archevoker_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.ARCHEVOKER, 0x0C0C0C, 0xCCA858, ItemPropertiesHelper.material().stacksTo(64)));
    public static final DeferredHolder<Item, DeferredSpawnEggItem> NECROMANCER_SPAWN_EGG = ITEMS.register("necromancer_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.NECROMANCER, 0x3E2B20, 0x515937, ItemPropertiesHelper.material().stacksTo(64)));
    public static final DeferredHolder<Item, DeferredSpawnEggItem> CRYOMANCER_SPAWN_EGG = ITEMS.register("cryomancer_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.CRYOMANCER, 0xFFFFFF, 0x97ffed, ItemPropertiesHelper.material().stacksTo(64)));
    public static final DeferredHolder<Item, DeferredSpawnEggItem> PYROMANCER_SPAWN_EGG = ITEMS.register("pyromancer_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.PYROMANCER, 0x7A1010, 0x262525, ItemPropertiesHelper.material().stacksTo(64)));
    public static final DeferredHolder<Item, DeferredSpawnEggItem> PRIEST_SPAWN_EGG = ITEMS.register("priest_spawn_egg", () -> new DeferredSpawnEggItem(EntityRegistry.PRIEST, 0xFFFFFF, 0xffde58, ItemPropertiesHelper.material().stacksTo(64)));
    //fixme: 3.2.0 rebase
    public static final RegistryObject<ForgeSpawnEggItem> APOTHECARIST_SPAWN_EGG = ITEMS.register("apothecarist_spawn_egg", () -> new ForgeSpawnEggItem(EntityRegistry.APOTHECARIST, 0x37542a, 0xd49277, ItemPropertiesHelper.material().stacksTo(64)));

    public static Collection<DeferredHolder<Item, ? extends Item>> getIronsItems() {
        return ITEMS.getEntries();
    }
}
