package spot.triviaplus;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class TriviaPlus extends JavaPlugin implements Listener {

	private static TriviaPlus instance;
	
    @Override
    public void onEnable() {
        // TODO Make this do something
    	instance = this;
    }
    
    @Override
    public void onDisable() {
    	// TODO Make this do something
    }
    
    public static TriviaPlus getInstance() {
    	return instance;
    }
    
    public static void registerEvents(Listener... listeners) {
        JavaPlugin plugin = instance;
        for (Listener l : listeners)
          Bukkit.getServer().getPluginManager().registerEvents(l, (Plugin)plugin); 
      }

}