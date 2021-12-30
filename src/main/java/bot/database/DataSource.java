package bot.database;

import bot.data.CounterType;
import bot.data.GreetingType;
import bot.data.InviteType;
import bot.database.mongo.MongoDS;
import bot.database.objects.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.List;

public interface DataSource {

    Logger LOGGER = LoggerFactory.getLogger(DataSource.class);
    DataSource INS = new MongoDS();

    // Guild Settings
    GuildSettings getSettings(String guildId);
    void setPrefix(String guildId, String newPrefix);
    void xpSystem(String guildId, boolean isEnabled);
    void setMaxWarnings(String guildId, int warnings);
    void setModLogChannel(String guildId, @Nullable String logChannel);

    // Automod Settings
    void setAutomodLogChannel(String guildId, @Nullable String channelId);
    void antiInvites(String guildId, boolean isEnabled);
    void antiLinks(String guildId, boolean isEnabled);
    void antiGhostPing(String guildId, boolean isEnabled);
    void setMaxLines(String guildId, int count);
    void setMaxMentions(String guildId, int count);
    void setMaxRoleMentions(String guildId, int count);

    // Reaction Role
    void addReactionRole(String guildId, String channelId, String messageId, String roleId, String emote);
    void removeReactionRole(String guildId, String channelId, String messageId);
    @Nullable String getReactionRoleId(String guildId, String channelId, String messageId, String emote);

    // Flag Translations
    void updateTranslationChannels(String guildId, List<String> channels);
    void addTranslation(String guildId, String channelId, String messageId, String unicode);
    boolean isTranslated(String guildId, String channelId, String messageId, String unicode);

    // Social & Levelling
    void setReputation(Member member, int rep);
    void setLevel(Member member, int level);
    int[] incrementXp(Member member, int xp, boolean updateMessages); // [oldLevel, oldXp, oldMessages]

    // Economy
    Economy getEconomy(Member member);
    int[] addCoins(Member member, int coins); // [oldCoins, newCoins]
    int[] removeCoins(Member member, int coins); // [oldCoins, newCoins]
    int[] updateDailyStreak(Member member, int coins, int streak); // [oldCoins, newCoins]

    // Moderation
    void warnUser(Member mod, Member target, String reason);
    void deleteWarnings(Member target);
    List<WarnLogs> getWarnLogs(Member member);
    void tempMute(String guildId, String memberId, Instant unmuteTime);
    void tempBan(String guildId, String memberId, Instant unbanTime);
    void checkTempMutes(JDA jda);
    void checkTempBans(JDA jda);

    // Counter Channels
    List<String> getCounterGuilds();
    CounterConfig getCounterConfig(String guildId);
    void updateBotCount(String guildId, boolean isIncrement, int count);
    void setCounter(CounterType type, Guild guild, @Nullable VoiceChannel vc, @Nullable String name);

    // Ticket
    void addTicketConfig(String guildId, String channelId, String messageId, String title, String roleId);
    @Nullable Ticket getTicketConfig(String guildId);
    void setTicketLogChannel(String guildId, String channelId);
    void setTicketLimit(String guildId, int limit);
    void setTicketClose(String guildId, boolean isAdminOnly);
    void deleteTicketConfig(String guildId);

    // Welcome & Farewell Data
    @Nullable Greeting getWelcomeConfig(String guildId);
    @Nullable Greeting getFarewellConfig(String guildId);
    void setGreetingChannel(String guildId, @Nullable String channelId, GreetingType type);

    // Welcome & Farewell Embed
    void setGreetingDesc(String guildId, @Nullable String description, GreetingType type);
    void setGreetingFooter(String guildId, @Nullable String description, GreetingType type);
    void setGreetingColor(String guildId, String color, GreetingType type);
    void setGreetingThumbnail(String guildId, boolean enabled, GreetingType type);
    void setGreetingImage(String guildId, String image, GreetingType type);

    // Guild Data
    void registerGuild(Guild guild, Member owner);

    // Invites
    int[] getInvites(String guildId, String memberId); // [total, fake, left]
    @Nullable String getInviterId(String guildId, String memberId);
    void removeInviterId(String guildId, String memberId);
    int[] incrementInvites(String guildId, String memberId, int amount, InviteType type); // [total, fake, left, added]
    void clearInviteData(String guildId);
    void clearInvites(String guildId, String memberId);
    void logInvite(String guildId, String memberId, String inviterId, String code);
    void inviteTracking(String guildId, boolean isEnabled);
    void addInvitesRank(String guildId, String roleId, int inviteCount);
    void removeInvitesRank(String guildId, int inviteCount);

}