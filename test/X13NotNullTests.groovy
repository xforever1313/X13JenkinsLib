//
//          Copyright Seth Hendrick 2020-2021.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

package net.shendrick.X13JenkinsLib.test

import com.lesfurets.jenkins.unit.BasePipelineTest
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource
import org.junit.*

class X13NotNullTests extends BasePipelineTest
{
    // ---------------- Setup / Teardown ----------------

    @Override
    @Before
    void setUp() throws Exception
    {
        super.setUp();
        def library = library()
            .name( "X13JenkinsLib" )
            .allowOverride( true )
            .implicit( true )
            .retriever( projectSource() )
            .build();

        helper.registerSharedLibrary( library );
    }

    // ---------------- Tests ----------------

    @Test
    void NullCausesErrorWithNameSpecifiedTest() throws Exception
    {
        def thing = null;
        X13NotNull( thing, "thing" );
    }

    @Test
    void NullCausesErrorWithoutNameSpecifiedTest() throws Exception
    {
        def thing = null;
        X13NotNull( thing );
    }
}