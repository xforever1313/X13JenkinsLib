//
//          Copyright Seth Hendrick 2020-2021.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - Logs into docker using the Docker Login command
///          with the supplied username/credentials
///          id.  This can either be a docker password
///          or an authorization token.
/// \param credsId - Required.  The credentials to use.
def call( Map args )
{
    X13NotNull( args["credsId"], "credsId" );

    withCredentials(
        [usernamePassword(
            credentialsId: args["credsId"],
            usernameVariable: "X13_DOCKER_LOGIN_USERNAME",
            passwordVariable: "X13_DOCKER_LOGIN_PASSWORD"
        )]
    )
    {
        String dockerCommand = "docker login --username ${X13_DOCKER_LOGIN_USERNAME} --password-stdin";
        if( isUnix() )
        {
            sh 'echo "$X13_DOCKER_LOGIN_PASSWORD" | ' + dockerCommand;
        }
        else
        {
            bat "echo %X13_DOCKER_LOGIN_PASSWORD%| ${dockerCommand}";
        }
    }
}
