package com.github.lunatrius.core.client.gui;

import com.github.lunatrius.core.handler.ConfigurationHandler;
import com.github.lunatrius.core.reference.Names;
import com.github.lunatrius.core.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

public class GuiModConfig extends GuiConfig {
    public GuiModConfig(GuiScreen guiScreen) {
        super(guiScreen, getConfigElements(), Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> elements = new ArrayList<IConfigElement>();
        for (String name : ConfigurationHandler.configuration.getCategoryNames()) {
            elements.add(new ConfigElement(ConfigurationHandler.configuration.getCategory(name).setLanguageKey(Names.Config.LANG_PREFIX + ".category." + name)));
        }
        return elements;
    }
}
