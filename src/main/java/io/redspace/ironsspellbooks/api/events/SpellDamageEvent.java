package io.redspace.ironsspellbooks.api.events;


import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

/**
 * SpellDamageEvent is fired when a LivingEntity is set to be hurt by a spell, via {@link io.redspace.ironsspellbooks.damage.DamageSources#applyDamage(Entity, float, DamageSource)}.<br>
 * This happens before Entity#hurt, meaning all other forge damage events will also fire if the damage succeeds.
 * <br>
 * <br>
 * This event is {@link Cancelable}.<br>
 * If this event is canceled, the Entity will not be hurt.<br>
 * <br>
 * This event does not have a result. {@link HasResult}<br>
 * <br>
 * This event is fired on the {@link net.neoforged.neoforge.common.NeoForge#EVENT_BUS}.<br>
 **/
public class SpellDamageEvent extends LivingEvent implements ICancellableEvent {
    //TODO: pre and post?
    private final SpellDamageSource spellDamageSource;
    private final float baseAmount;
    private float amount;

    public SpellDamageEvent(LivingEntity livingEntity, float amount, SpellDamageSource spellDamageSource) {
        super(livingEntity);
        this.spellDamageSource = spellDamageSource;
        this.baseAmount = amount;
        this.amount = this.baseAmount;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }

    public float getOriginalAmount() {
        return this.baseAmount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public SpellDamageSource getSpellDamageSource() {
        return this.spellDamageSource;
    }
}
