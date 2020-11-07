package com.spxctreofficial.enhancedcraft.registry.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import com.spxctreofficial.enhancedcraft.registry.ModRegistry;

import java.util.function.Supplier;

public enum CustomArmorMaterials implements ArmorMaterial {
    EtheriumArmor("etherium", 35, new int[]{5, 8, 10, 5}, 35, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20.0F, 0.65F, () -> {
        return Ingredient.ofItems(ModRegistry.Etherium);
    }),
    BronzeArmor("bronze", 12, new int[]{1, 5, 5, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModRegistry.BronzeIngot);
    }),
    AlloyArmor("alloy", 28, new int[]{3, 5, 7, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModRegistry.MetalAlloy);
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    CustomArmorMaterials(final String string_1, final int int_1, final int[] ints_1, final int int_2, final SoundEvent soundEvent_1, final float float_1, final float float_2, final Supplier<Ingredient> supplier_1) {
        this.name = string_1;
        this.durabilityMultiplier = int_1;
        this.protectionAmounts = ints_1;
        this.enchantability = int_2;
        this.equipSound = soundEvent_1;
        this.toughness = float_1;
        this.knockbackResistance = float_2;
        this.repairIngredientSupplier = new Lazy<>(supplier_1);
    }

    public int getDurability(final EquipmentSlot equipmentSlot_1) {
        return BASE_DURABILITY[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(final EquipmentSlot equipmentSlot_1) {
        return this.protectionAmounts[equipmentSlot_1.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}