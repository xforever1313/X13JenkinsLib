//
//          Copyright Seth Hendrick 2020-2022.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

String call( String path1, String path2 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2;
}

String call( String path1, String path2, String path3 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3;
}

String call( String path1, String path2, String path3, String path4 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4;
}

String call( String path1, String path2, String path3, String path4, String path5 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4 + sep + path5;
}

String call( String path1, String path2, String path3, String path4, String path5, String path6 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4 + sep + path5 + sep + path6;
}

String call( String path1, String path2, String path3, String path4, String path5, String path6, String path7 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4 + sep + path5 + sep + path6 + sep + path7;
}

String call( String path1, String path2, String path3, String path4, String path5, String path6, String path7, String path8 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4 + sep + path5 + sep + path6 + sep + path7 + sep + path8;
}

String call( String path1, String path2, String path3, String path4, String path5, String path6, String path7, String path8, String path9 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4 + sep + path5 + sep + path6 + sep + path7 + sep + path8 + sep + path9;
}

String call( String path1, String path2, String path3, String path4, String path5, String path6, String path7, String path8, String path9, String path10 )
{
    char sep = GetSeparatorPath();
    
    return path1 + sep + path2 + sep + path3 + sep + path4 + sep + path5 + sep + path6 + sep + path7 + sep + path8 + sep + path9 + sep + path10;
}

char GetSeparatorPath()
{
    if( isUnix() )
    {
        return '/';
    }
    else
    {
        return '\\';
    }
}