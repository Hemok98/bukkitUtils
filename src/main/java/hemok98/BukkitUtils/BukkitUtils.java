package hemok98.BukkitUtils;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

public final class BukkitUtils extends JavaPlugin {

    private static BukkitUtils instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BukkitUtils getInstance(){
        return instance;
    }

    @Nullable
    public static String queryPlayerName(UUID uuid) {
        Player onlinePlayer = Bukkit.getPlayer(uuid);
        if (onlinePlayer != null) {
            return onlinePlayer.getName();
        } else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);
            if (offlinePlayer.getName() != null) {
                return offlinePlayer.getName();
            } else {
                try {
                    String hexUuid = uuid.toString().replaceAll("-", "");
                    JSONObject UUIDObject = getBody(new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + hexUuid));
                    return UUIDObject.get("name").toString();
                } catch (IOException var5) {
                    return null;
                } catch (ParseException var6) {
                    var6.printStackTrace();
                    return null;
                }
            }
        }
    }

    @Nullable
    public static UUID queryPlayerUuid(String name) {
        Player onlinePlayer = Bukkit.getPlayer(name);
        if (onlinePlayer != null) {
            return onlinePlayer.getUniqueId();
        } else {
            try {
                JSONObject UUIDObject = getBody(new URL("https://api.mojang.com/users/profiles/minecraft/" + name));
                String uuidStr = UUIDObject.get("id").toString();
                if (uuidStr == null) {
                    return null;
                } else {
                    return uuidStr.length() != 32 ? null : UUID.fromString(uuidStr.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
                }
            } catch (IOException var4) {
                return null;
            } catch (ParseException var5) {
                var5.printStackTrace();
                return null;
            }
        }
    }

    private static JSONObject getBody(URL url) throws IOException, ParseException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        Throwable var3 = null;

        try {
            String inputLine;
            try {
                while((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                    sb.append("\n");
                }
            } catch (Throwable var12) {
                var3 = var12;
                throw var12;
            }
        } finally {
            if (in != null) {
                if (var3 != null) {
                    try {
                        in.close();
                    } catch (Throwable var11) {
                        var3.addSuppressed(var11);
                    }
                } else {
                    in.close();
                }
            }

        }

        return (JSONObject) JSONValue.parseWithException(sb.toString());
    }
}
