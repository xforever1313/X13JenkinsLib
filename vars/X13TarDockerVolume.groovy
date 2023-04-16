//
//          Copyright Seth Hendrick 2020-2023.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - Tars a docker volume's contents.
///          This can only be run on Linux systems.
/// \param volumeName - The name of the docker volume to backup.
/// \param tarFileName - What to name the tar file (do not include file extension)
def call( Map args )
{
    X13NotNull( args["volumeName"], "volumeName" );
    X13NotNull( args["tarFileName"], "tarFileName" );

    // Taken from here:
    // https://docs.docker.com/storage/volumes/#backup-restore-or-migrate-data-volumes
    // --volumes-from mountes all volumes bound to the container.
    //
    // --rm: Remove after running
    // -v: Mount the volume to the container's volume.
    // -v: Mount backups to the current working directory of the host
    // tar: Put the tar in /backup in the container, but make the working directory /volume, and back up ./ (so backup /volume)
    sh "docker run --rm --mount source=${args["volumeName"]},destination=/volume,readonly -v \"${pwd()}\":/backup ubuntu:22.04 tar cvf /backup/${args["tarFileName"]}.tar.gz -C /volume ./";
}
