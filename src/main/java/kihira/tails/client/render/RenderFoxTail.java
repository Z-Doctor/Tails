package kihira.tails.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kihira.tails.client.model.ModelFoxTail;
import kihira.tails.common.TailInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFoxTail extends RenderTail {

	private String[] skinNames = {"foxTail"};
	
    private ModelFoxTail modelFoxTail = new ModelFoxTail();

    public RenderFoxTail() {
        super("fox");
    }

    @Override
    public void render(EntityLivingBase player, TailInfo info) {
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(info.getTexture());
        if (!player.isSneaking()) GL11.glTranslatef(0F, 0.65F, 0.1F);
        else GL11.glTranslatef(0F, 0.55F, 0.4F);
        GL11.glScalef(0.8F, 0.8F, 0.8F);
        this.modelFoxTail.render(player, info.subid);
        GL11.glPopMatrix();
    }
    
    @Override
	public String[] getTextureNames() {
		return skinNames;
	}

    @Override
    public int getAvailableSubTypes() {
        return 0;
    }
}
