package rebelkeithy.mods.atum.items;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import rebelkeithy.mods.atum.entities.EntityPharaoh;
import rebelkeithy.mods.atum.entities.EntityStoneSoldier;

public class ItemGreatsword extends ItemSword {

   public ItemGreatsword(int par1, EnumToolMaterial par2EnumToolMaterial) {
      super(par1, par2EnumToolMaterial);
   }

   public boolean hitEntity(ItemStack par1ItemStack, EntityLiving mob, EntityLiving player) {
      if(!(mob instanceof EntityStoneSoldier) && !(mob instanceof EntityPharaoh)) {
         float j = 1.2F;
         mob.addVelocity((double)(-MathHelper.sin(player.rotationYaw * 3.1415927F / 180.0F) * j * 0.5F), 0.1D, (double)(MathHelper.cos(player.rotationYaw * 3.1415927F / 180.0F) * j * 0.5F));
      }

      return super.hitEntity(par1ItemStack, mob, player);
   }
}
