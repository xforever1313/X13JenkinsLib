//
//          Copyright Seth Hendrick 2020-2022.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

void call( String project, String args, Boolean noBuild = true )
{
    String noBuildString = noBuild ? "--no-build " : "";
    X13Cmd( "dotnet run ${noBuildString}--project='${project}' -- ${args}" );
}
