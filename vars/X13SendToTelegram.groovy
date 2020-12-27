//
//          Copyright Seth Hendrick 2020.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - Sends a message to the given Telegram chat.
/// 
/// \details - There are a few things that need to be done before this function will work.
///            
///            First, the HttpRequest Jenkins Plugin must be installed.
///            It is located here: https://plugins.jenkins.io/http_request/
///
///            Second, you must create a Telegram bot.  To do this, Message the BotFather
///            (@BotFather) with the message "/newbot".  Give it a name and a username
///            (username must end in "bot").  It will then give you the token to use
///            with the API.  Do not lose this, and do not let it leak.
///
///            Third, create a Telegram Group or Channel (depending on your use case).
///            Have the bot join it.  It is recommended that after doing this,
///            message the @BotFather "/setjoingroups" and then "@yourBotName" so no one
///            else can have it join the group.
///
///            Fourth, to get the chat ID to send a message to, send a message to the group
///            or channel you are in.  Then go to https://api.telegram.org/botYOUR_API_KEY/getUpdates
///            and search for your group or channel name.  An "id" field should appear under a "chat" class,
///            should be there and that is the chat ID.
///
///            It is strongly recommended that the chatId and botApiToken are wrapped in a withCredentials
///            call somehow so they are hidden in logs.  I personally have the botApiToken be username/password
///            with the username being the bot username, and the password being the API token.
///            The chatId is Secret Text.
///
/// \param message - Required.  The message to send to the Telegram group or channel.
///                  This can be markdown if your group supports that.
///
/// \param chatId - Required.  The chat ID to send the message to.
/// \param botApiToken - Required.  The bot's API token.
/// \param failBuildOnBadResponse - Defaulted to "false".  Set to true to fail a build the HTTP request fails.
void call( Map args )
{
    X13NotNull( args["message"], "message" );
    X13NotNull( args["chatId"], "chatId" );
    X13NotNull( args["botApiToken"], "botApiToken" );

    if( args["failBuildOnBadResponse"] == null )
    {
        args["failBuildOnBadResponse"] = false;
    }

    String escapedMessage = "";
    args["message"].each
    {
        ch ->
        {
            if( ch == '\'' )
            {
                escapedMessage += "\\'";
            }
            else
            {
                escapedMessage += ch;
            }
        }
    };

    String content = "{'chat_id': '${args["chatId"]}', 'text': '${escapedMessage}'}";

    httpRequest(
        consoleLogResponseBody: true,
        contentType: "APPLICATION_JSON",
        httpMode: "POST",
        ignoreSslErrors: true,
        requestBody: content,
        responseHandle: "NONE",
        url: "https://api.telegram.org/bot${args["botApiToken"]}/METHOD_NAME"
    );
}