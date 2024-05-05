//
//          Copyright Seth Hendrick 2020-2023.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - Runs a command on any operating system.  If a Unix system,
///          this calls "sh" while on a Windows system,
///          this calls "bat".
///
/// \param command - The command to run in the shell.
/// \param label - Label to be displayed in the pipeline step view.
/// \param returnStdOut - If set to true,
///                       standard output from the task is returned
///                       as a string.  This takes precedence over returnStatus.
/// \param returnStatus - If set to true, the exit code is returned from this method.
///                       If set to false, the job will fail if the exit code is not zero.
def call(
    String command,
    String label = null,
    boolean returnStdout = false,
    boolean returnStatus = false
)
{
    if( returnStdout )
    {
        if ( isUnix() )
        {
            return sh( script: command, label: label, returnStdout: true );
        }
        else
        {
            return bat( script: command, label: label, returnStdout: true );
        }
    }
    else if( returnStatus )
    {
        if( isUnix() )
        {
            return sh( script: command, label: label, returnStatus: true );
        }
        else
        {
            return bat( script: command, label: label, returnStatus: true );
        }
    }
    else
    {
        if( isUnix() )
        {
            sh( script: command, label: label );
        }
        else
        {
            bat( script: command, label: label );
        }
    }
}

