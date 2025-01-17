package com.dakuo.onemail;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author 大阔
 * @since 2025/1/17 17:20
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("OneMail启动成功");
    }
}
