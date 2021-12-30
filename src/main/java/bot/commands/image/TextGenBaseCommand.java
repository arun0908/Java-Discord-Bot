package bot.commands.image;

import bot.Constants;
import bot.command.CommandCategory;
import bot.command.CommandContext;
import bot.command.ICommand;
import bot.data.ImageType;
import bot.utils.ImageUtils;
import me.duncte123.botcommons.messaging.EmbedUtils;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public abstract class TextGenBaseCommand extends ICommand {

    public TextGenBaseCommand() {
        this.name = getClass().getSimpleName().toLowerCase();
        this.usage = "<text>";
        this.minArgsCount = 1;
        this.help = "generates a meme for the provided text content";
        this.category = CommandCategory.IMAGE;
        this.cooldown = 5;
    }

    @Override
    public void handle(@Nonnull @NotNull CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final User author = ctx.getAuthor();

        WebUtils.ins.getByteStream(ImageUtils.getTextGenerator(this.getEndpoint(), ctx.getArgsJoined())).async(bytes -> {
            EmbedBuilder embed = EmbedUtils.getDefaultEmbed()
                    .setColor(Constants.TRANSPARENT_EMBED)
                    .setFooter("Requested by: " + author.getAsTag());

            ImageUtils.embedImage(channel, embed, bytes, this.getImageType());

        }, err -> {
            LOGGER.error(err.getMessage());
            ctx.replyError(Constants.API_ERROR);
        });

    }

    public String getEndpoint() {
        return this.name;
    }

    public ImageType getImageType() {
        return ImageType.IMAGE;
    }

}
