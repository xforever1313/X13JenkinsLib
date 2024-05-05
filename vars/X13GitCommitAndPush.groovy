//
//          Copyright Seth Hendrick 2020-2023.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - Performs a git commit and pushes it to the origin.
///
/// Required Params:
///    \param checkoutFolder - Where the root of the checkout is.
///    \param userName - The name to commit as.
///    \param email - The email to commit as.
///    \param credentials - The credentials ID to use to talk to the SSH agent.
///    \param message - The commit message.
void call( Map args )
{
    X13NotNull( args["checkoutFolder"], "checkoutFolder" );
    X13NotNull( args["userName"], "userName" );
    X13NotNull( args["email"], "email" );
    X13NotNull( args["credentials"], "credentials" );
    X13NotNull( args["message"], "message" );

    dir( args["checkoutFolder"] )
    {
        X13Cmd( "git config --local user.name '${args["userName"]}' && git config --local user.email '${args["email"]}'" );
        def statusCode = X13Cmd( command: "git diff --quiet", null, false, true );
        if( statusCode == 1 )
        {
            println( "No changes to commit, returning." );
            return;
        }

        X13Cmd( "git commit -a -m '${args["message"]}'" );
        sshagent(credentials: [args["credentials"]])
        {
            X13Cmd( "git push" );
        }
    }
}
