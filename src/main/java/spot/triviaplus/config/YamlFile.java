package spot.triviaplus.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import spot.triviaplus.TriviaPlus;

public class YamlFile {
  protected String fileName;
  
  protected File file;
  
  protected FileConfiguration loadedFile = (FileConfiguration)new YamlConfiguration();
  
  protected JavaPlugin plugin;
  
  public YamlFile(JavaPlugin plugin, String fileName) {
    this.plugin = plugin;
    this.fileName = fileName;
    this.file = new File(plugin.getDataFolder(), fileName);
    createFile();
    load();
  }
  
  public YamlFile(JavaPlugin plugin, File file) {
    this.plugin = plugin;
    this.fileName = file.getName();
    this.file = file;
    createFile();
    load();
  }
  
  public YamlFile(String fileName) {
    this.plugin = TriviaPlus.getInstance();
    this.fileName = fileName;
    this.file = new File(this.plugin.getDataFolder(), fileName);
    createFile();
    load();
  }
  
  public YamlFile(File file) {
    this.plugin = TriviaPlus.getInstance();
    this.fileName = file.getName();
    this.file = file;
    createFile();
    load();
  }
  
  public void save() {
    try {
      this.loadedFile.save(this.file);
    } catch (IOException e) {
      Bukkit.getLogger().warning("Unable to save " + this.fileName);
    } 
  }
  
  private void load() {
    try {
      this.loadedFile.load(this.file);
    } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
      e.printStackTrace();
      Bukkit.getLogger().warning("Unable to load " + this.fileName);
    } 
  }
  
  private void createFile() {
    if (!this.file.exists())
      try {
        this.file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }  
  }
  
  public void reload() {
    this.loadedFile = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
    Bukkit.getLogger().info("Configuration file (" + this.fileName + ") has been reloaded.");
  }
  
  public FileConfiguration getLoadedFile() {
    return this.loadedFile;
  }
  
  public List<String> getList(String path) {
    return this.loadedFile.getStringList(path);
  }
  
  public String getValue(String path) {
    return this.loadedFile.getString(path);
  }
  
  public List<String> getCommaList(String path) {
    String line = this.loadedFile.getString(path);
    String[] arr = line.split(",");
    List<String> list = new ArrayList<>();
    for (String s : arr)
      list.add(s.trim()); 
    return list;
  }
}
