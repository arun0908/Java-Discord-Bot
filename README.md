<h1 align="center">JDA 4 Discord Bot</h1>
<p align="center">A cool multipurpose bot built using <a href="https://github.com/DV8FromTheWorld/JDA">Java Discord API</a></p>

# Features
- Powerful Moderation
- Auto Moderation
- Reaction Roles
- Customised Welcome/Farewell messages
- Advanced Ticketing System
- Stats Counter Channels
- Translation
- Image Manipulation <br>

_And Much more ..._

# Quick Links
- Join our support server: [Discord Link](https://discord.gg/nggZxPN)
- Add me here: [Invite](https://discord.com/oauth2/authorize?scope=bot&client_id=752922609733337190&permissions=8)

## Available Commands
### Utility Commands:
Command | Description
------------ | -------------
`-covid <country>` | Get covid statistics in the specified country
`-github <username>` | Shows github statistics of a user
`-haste <text>` | Posts some text to hastebin
`-help <command>` | Shows the list with commands in the bot
`-translate <code> <text>` | Translate from one language to other
`-trcodes` | Displays a list of available translate codes
`-urban <search-term>` | Searches the urban dictionary
`-proxies` | Fetch fresh proxies (http, socks4, socks5)
`-http` | Fetch fresh http proxies
`-socks4` | Fetch fresh socks4 proxies
`-socks5` | Fetch fresh socks5 proxies

### Fun Commands:
Command | Description
------------ | -------------
`-animal <name>` | Show a random image of selected animal types
`-cat` | Shows a random cat image
`-dog` | Shows a random dog image
`-joke` | Shows a random joke
`-flipcoin` | Flips a coin heads or tails
`-fliptext` | Reverses the given message
`-meme` | Shows a random meme

### Information Commands
Command | Description
------------ | -------------
`-avatar` | Displays avatar information about the user
`-botinfo` | Shows bot information
`-channelinfo [#channel]` | Shows mentioned channel information
`-guildinfo` | Shows information about the discord server
`-invite` | Get the bot's invite
`-ping` | Shows the current ping from the bot to the discord servers
`-roleinfo` | Shows information of the specified role
`-uptime` | Shows bot's uptime
`-userinfo` | Shows information about the user

### Image Commands
```
All the below specified commands can be used in the following format

-cmd: This uses self users avatar as image
-cmd <image-url>: This picks image from provided URL
-cmd <@member>: This uses the mentioned users avatar as image
-cmd <attachment>: This picks image from attachment
```
###### Image Filters
<table>
   <tr>
      <td>blur</td>
      <td>contrast</td>
      <td>gay</td>
      <td>greyscale</td>
      <td>invert</td>
      <td>sepia</td>
   </tr>
</table>

###### Image Generators
<table>
   <tr>
      <td>ad</td>
      <td>affect</td>
      <td>approved</td>
      <td>batslap</td>
      <td>beautiful</td>
   </tr>
   <tr>
      <td>bed</td>
      <td>delete</td>
      <td>discordblack</td>
      <td>discordblue</td>
      <td>doublestonk</td>
   </tr>
   <tr>
      <td>facepalm</td>
      <td>frame</td>
      <td>hitler</td>
      <td>jail</td>
      <td>karaba</td>
   </tr>
   <tr>
      <td>kiss</td>
      <td>mms</td>
      <td>notstonk</td>
      <td>podium</td>
      <td>poutine</td>
   </tr>
   <tr>
      <td>rejected</td>
      <td>rip</td>
      <td>spank</td>
      <td>stonk</td>
      <td>tatoo</td>
   </tr>
   <tr>
      <td>trash</td>
      <td>wanted</td>
   </tr>
</table>

###### Text Generators
<table>
   <tr>
      <td>achievement</td>
      <td>belikebill</td>
      <td>presentation</td>
   </tr>
</table>

### Economy Commands

Command | Description
------------ | -------------
`-balance [@member]` | Shows your current coin balance
`-daily` | Receive a daily coin bonus
`-gamble <amount>` | Try your luck by gambling
`-transfer <coins> <@member>` | Transfer coins to other user

### Social Commands

Command | Description
------------ | -------------
`-rep [@member]` | Give reputation to a user

### Moderation Commands

Command | Description
------------ | -------------
`-ban <@member(s)> [reason]` | Ban the the mentioned member(s)
`-clearwarnings <@member>` | Clears previous warnings received by a member
`-deafen <@member(s)> [reason]` | Deafen's the mentioned member(s)
`-kick <@member(s)> [reason]` | Kick the mentioned member(s)
`-mute <@member(s)> [reason]` | Mute the mentioned member(s) on all text/voice channels
`-purgeattach <amount>` | Deletes the specified amount of messages with attachments
`-purgebots <amount>` | Deletes the specified amount of messages from bots
`-purge <amount>` | Deletes the specified amount of messages
`-purgelinks <amount>` | Deletes the specified amount of messages with links
`-purgeuser <@user> <amount>` | Deletes the specified amount of messages for the mentioned user
`-setnick <@member> <new-name>`| change the mentioned user's nickname
`-softban <@member(s)> [reason]` | Kicks a member from the server and delete that users messages
`-tempban <@member(s)> <time> [reason]` | Bans the mentioned member(s) for the specified amount of time
`-tempmute <@member(s)> <time> [reason]` | Mute the mentioned member(s) for the specified amount of time
`-undeafen <@member(s)> [reason]` | Undeafen's the mentioned member(s)
`-unmute <@member(s)> [reason]` | Unmutes the specified member(s)
`-vmute <@member(s)> [reason]` | Mute voice of the mentioned member(s)
`-vunmute <@member(s)> [reason]` | UnMute voice of the mentioned member(s)
`-warn <@member(s)> [reason]` | Gives warning to the mentioned member(s)
`-warnings <@member>` | Displays warnings received by mentioned user

### Auto Moderation
> - These commands can only be configured by members who have Permission.MANAGE_SERVER
> - The bot moderates messages only in channels where it has Permission.MESSAGE_MANAGE
> - The bot ignores messages sent by users having Permission.KICK_MEMBERS, Permission.BAN_MEMBERS, Permission.MANAGE_SERVER

Command | Description
------------ | -------------
`-automodstatus` | check automod configuration for this guild
`-automodlog <#channel\|OFF>` | set/disable logging for all automod events
`-antiinvites <ON\|OFF>` | allow or disallow sending discord links in message
`-antilinks <ON\|OFF>` | allow or disallow sending links in message
`-maxlines <number\|OFF>` | sets maximum lines allowed per message
`-maxmentions <number\|OFF>` | sets maximum user mentions allowed per message
`-maxrolementions <number\|OFF>` | sets maximum role mentions allowed per message
