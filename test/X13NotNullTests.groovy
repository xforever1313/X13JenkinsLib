//
//          Copyright Seth Hendrick 2020-2021.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

package net.shendrick.X13JenkinsLib.test

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.*

class X13NotNullTests extends BasePipelineTest
{
   // ---------------- Fields ----------------

   def uut;

   // ---------------- Setup / Teardown ----------------

    @Override
    @Before
    void setUp() throws Exception
    {
        super.setUp();
        this.uut = loadScript( "vars/X13NotNull.groovy" );
    }

    // ---------------- Tests ----------------

    @Test
    void NullCausesErrorWithNameSpecifiedTest() throws Exception
    {
        // Setup
        def thing = null;

        // Act
        this.uut.call( thing, "thing" );

        // Check
        assertJobStatusFailure();
    }

    @Test
    void NullCausesErrorWithoutNameSpecifiedTest() throws Exception
    {
        // Setup
        def thing = null;

        // Act
        this.uut.call( thing );

        // Check
        assertJobStatusFailure();
    }

    @Test
    void NotNullDoesNotCauseErrorTest() throws Exception
    {
        // Setup
        def thing = "Hello";

        // Act
        this.uut.call( thing, "thing" );

        // Check
        assertJobStatusSuccess();
    }

    @Test
    void NotNullDoesNotCauseErrorWithoutNameSpecifiedTest() throws Exception
    {
        // Setup
        def thing = "hello";

        // Act
        this.uut.call( thing );

        // Check
        assertJobStatusSuccess();
    }
}

