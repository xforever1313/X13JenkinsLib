//
//          Copyright Seth Hendrick 2020-2023.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - This does the same thing as X13SendToTelegram.groovy,
///          but it takes care of setting up the crentials for you.
///
/// \details - In addition to the prerecs called out in the details section of
///            X13SendToTelegram.groovy, you must also set up credentials in Jenkins.
///            You must set up a username/password credential that contains
///            the username of the Telegram bot as the user name, and the bot API token
///            as the password.  The chatId must be a separate credential,
///            whose type is "secret text".
/// 
/// \param botCredsId - Required.  The credentials ID of the username/password credentials that contains
///                     the bot username/password.
///
/// \param chatCredsId - Required.  The credentials ID of the secret text credentials that contains
///                      the chat ID.
/// \param message - Required.  The message to send to the Telegram group or channel.
///                  This can be markdown if your group supports that.
///
/// \param chatId - Required.  The chat ID to send the message to.
/// \param botApiToken - Required.  The bot's API token.
void call( Map args )
{
    X13NotNull( args["botCredsId"], "botCredsId" );
    X13NotNull( args["chatCredsId"], "chatCredsId" );

    withCredentials(
        [usernamePassword(
            credentialsId: args["botCredsId"],
            passwordVariable: 'x13_tg_bot_api_key',
            usernameVariable: 'x13_tg_bot_username'
        )]
    )
    {
        withCredentials(
            [string(
                credentialsId: args["chatCredsId"],
                variable: 'x13_tg_bot_chat_id'
            )]
        )
        {
            args["chatId"] = x13_tg_bot_chat_id;
            args["botApiToken"] = x13_tg_bot_api_key;
            args["botCredsId"] = null;
            args["chatCredsId"] = null;
            X13SendToTelegram( args );
        }
    }
}