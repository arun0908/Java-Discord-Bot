package bot.commands.utility;

import bot.Constants;
import bot.command.CommandCategory;
import bot.command.CommandContext;
import bot.command.ICommand;
import bot.utils.HttpUtils;
import me.duncte123.botcommons.messaging.EmbedUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class TranslateCommand extends ICommand {

    public TranslateCommand() {
        this.name = "translate";
        this.help = "translate from one language to other";
        this.minArgsCount = 2;
        this.multilineHelp = true;
        this.usage = "```{p}{i} <language-code> <text>```\nType `{p}trcodes` to see list of supported language codes\n";
        this.aliases = Collections.singletonList("tr");
        this.category = CommandCategory.UTILS;
        this.cooldown = 5;
    }

    @Override
    public void handle(@NotNull CommandContext ctx) {
        final List<String> args = ctx.getArgs();
        final String outputCode = args.get(0);

        if (!Constants.langCodes.containsKey(outputCode)) {
            EmbedBuilder eb = EmbedUtils.getDefaultEmbed()
                    .setDescription("Invalid Translation code: `" + outputCode
                            + "`\n\n" + "Type `" + ctx.getPrefix() + "trcodes` to get a list of available translate codes");
            ctx.reply(eb.build());
            return;
        }

        final String input = ctx.getMessage().getContentStripped().split(" ", 3)[2];

        try {
            String[] translate = HttpUtils.translate(outputCode, input);

            if (translate == null) {
                ctx.reply("No translation found");
                return;
            }

            String footer = translate[2] + " (" + translate[0] + ")" + " ⟶ " + translate[3] + " (" + translate[1] + ")";

            EmbedBuilder eb = EmbedUtils.getDefaultEmbed()
                    .setDescription(translate[5])
                    .setAuthor(ctx.getAuthor().getName() + " says", null, ctx.getAuthor().getEffectiveAvatarUrl())
                    .setFooter(footer);

            ctx.reply(eb.build());

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            ctx.replyError(Constants.API_ERROR);

        }

    }

}
