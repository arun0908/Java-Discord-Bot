package bot.commands.fun;

import bot.Constants;
import bot.command.CommandCategory;
import bot.command.CommandContext;
import bot.command.ICommand;
import com.fasterxml.jackson.databind.JsonNode;
import me.duncte123.botcommons.messaging.EmbedUtils;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import org.jetbrains.annotations.NotNull;

public class CatCommand extends ICommand {

    public CatCommand() {
        this.name = "cat";
        this.help = "Shows a random cat image";
        this.botPermissions = new Permission[]{Permission.MESSAGE_EMBED_LINKS};
        this.category = CommandCategory.FUN;
        this.cooldown = 5;
    }

    @Override
    public void handle(@NotNull CommandContext ctx) {
        WebUtils.ins.getJSONArray("https://api.thecatapi.com/v1/images/search").async((json) -> {
            final JsonNode item = json.get(0);
            String image = item.get("url").asText();

            final EmbedBuilder embed = EmbedUtils.getDefaultEmbed()
                    .setImage(image)
                    .setFooter("Requested by " + ctx.getAuthor().getAsTag());

            ctx.reply(embed.build());

        }, err -> {
            LOGGER.error(err.getMessage());
            ctx.replyError(Constants.API_ERROR);
        });
    }

}
