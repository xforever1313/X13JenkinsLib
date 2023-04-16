//
//          Copyright Seth Hendrick 2020-2023.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief Tars all ignored files inside of a git repo
///        so they are not lost.
///        This can only be run on Linux systems.
/// \param gitRepoPath - Path to the git repo.
/// \param archivePath - Where to dump the archive to.
def call( Map args )
{
    X13NotNull( args["gitRepoPath"], "gitRepoPath" );
    X13NotNull( args["archivePath"], "archivePath" );

    String ignoredFiles = "";
    dir( args["gitRepoPath"] )
    {
        // Any files we want to backup are any not in the git repo.
        // So, tar up any files not in the git repo, and that's our backup.
        ignoredFiles = sh(
            returnStdout: true,
            script: "git ls-files --ignored --others --exclude-standard"
        );
    }

    // -C changes to the directory before archiving.
    String command = "tar --create --file=\"${args["archivePath"]}\" -v -C ${args["gitRepoPath"]} "
    for( file in ignoredFiles.split( '\n' ) )
    {
        command += " \"${file}\"";
    }

    sh command;
}
