//
//          Copyright Seth Hendrick 2020-2022.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

package net.shendrick.X13JenkinsLib.test

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.*

class X13CmdTests extends BasePipelineTest
{
   // ---------------- Fields ----------------

   def uut;

   // ---------------- Setup / Teardown ----------------

    @Override
    @Before
    void setUp() throws Exception
    {
        super.setUp();
        this.uut = loadScript( "vars/X13Cmd.groovy" );
    }

    // ---------------- Tests ----------------

    @Test
    void SendCommandOnWindowsNoStdOutArgTest()
    {
        // Setup
        final String expectedCommand = "dir c:\\";
        final String expectedLabel = "My Label";

        String actualCommand = null;
        String actualLabel = null;
        def actualStdOut = null;

        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );
        helper.registerAllowedMethod(
            "bat",
            [Map.class],
            { 
                m ->
                    actualCommand = m.script;
                    actualLabel = m.label;
                    actualStdOut = m.returnStdout;

            }
        );

        // Act

        // No argument should default to false.
        this.uut.call( expectedCommand, expectedLabel );

        // Check
        Assert.assertEquals( expectedCommand, actualCommand );
        Assert.assertEquals( expectedLabel, actualLabel );
        Assert.assertNull( actualStdOut );
    }

    @Test
    void SendCommandOnWindowsNoStdOutTest()
    {
        // Setup
        final String expectedCommand = "dir c:\\";
        final String expectedLabel = "My Label";

        String actualCommand = null;
        String actualLabel = null;
        def actualStdOut = null;

        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );
        helper.registerAllowedMethod(
            "bat",
            [Map.class],
            { 
                m ->
                    actualCommand = m.script;
                    actualLabel = m.label;
                    actualStdOut = m.returnStdout;
            }
        );

        // Act
        this.uut.call( expectedCommand, expectedLabel, false );

        // Check
        Assert.assertEquals( expectedCommand, actualCommand );
        Assert.assertEquals( expectedLabel, actualLabel );
        Assert.assertNull( actualStdOut );
    }

    @Test
    void SendCommandOnWindowsWithStdOutTest()
    {
        // Setup
        final String expectedCommand = "dir c:\\";
        final String expectedLabel = "My Label";
        final String expectedStdOut = "COMMAND OUTPUT";

        String actualCommand = null;
        String actualLabel = null;

        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );
        helper.registerAllowedMethod(
            "bat",
            [Map.class],
            { 
                m ->
                    actualCommand = m.script;
                    actualLabel = m.label;
                    if( m.returnStdout )
                    {
                        return expectedStdOut;
                    }
                    else
                    {
                        return "";
                    }
            }
        );

        // Act
        String actualStdOut = this.uut.call( expectedCommand, expectedLabel, true );

        // Check
        Assert.assertEquals( expectedCommand, actualCommand );
        Assert.assertEquals( expectedLabel, actualLabel );
        Assert.assertEquals( expectedStdOut, actualStdOut );
    }

    @Test
    void SendCommandOnUnixNoStdOutArgTest()
    {
        // Setup
        final String expectedCommand = "ls /";
        final String expectedLabel = "My Label";

        String actualCommand = null;
        String actualLabel = null;
        def actualStdOut = null;

        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );
        helper.registerAllowedMethod(
            "sh",
            [Map.class],
            { 
                m ->
                    actualCommand = m.script;
                    actualLabel = m.label;
                    actualStdOut = m.returnStdout;

            }
        );

        // Act

        // No argument should default to false.
        this.uut.call( expectedCommand, expectedLabel );

        // Check
        Assert.assertEquals( expectedCommand, actualCommand );
        Assert.assertEquals( expectedLabel, actualLabel );
        Assert.assertNull( actualStdOut );
    }

    @Test
    void SendCommandOnUnixNoStdOutTest()
    {
        // Setup
        final String expectedCommand = "ls /";
        final String expectedLabel = "My Label";

        String actualCommand = null;
        String actualLabel = null;
        def actualStdOut = null;

        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );
        helper.registerAllowedMethod(
            "sh",
            [Map.class],
            { 
                m ->
                    actualCommand = m.script;
                    actualLabel = m.label;
                    actualStdOut = m.returnStdout;
            }
        );

        // Act
        this.uut.call( expectedCommand, expectedLabel, false );

        // Check
        Assert.assertEquals( expectedCommand, actualCommand );
        Assert.assertEquals( expectedLabel, actualLabel );
        Assert.assertNull( actualStdOut );
    }

    @Test
    void SendCommandOnUnixWithStdOutTest()
    {
        // Setup
        final String expectedCommand = "ls /";
        final String expectedLabel = "My Label";
        final String expectedStdOut = "COMMAND OUTPUT";

        String actualCommand = null;
        String actualLabel = null;

        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );
        helper.registerAllowedMethod(
            "sh",
            [Map.class],
            { 
                m ->
                    actualCommand = m.script;
                    actualLabel = m.label;
                    if( m.returnStdout )
                    {
                        return expectedStdOut;
                    }
                    else
                    {
                        return "";
                    }
            }
        );

        // Act
        String actualStdOut = this.uut.call( expectedCommand, expectedLabel, true );

        // Check
        Assert.assertEquals( expectedCommand, actualCommand );
        Assert.assertEquals( expectedLabel, actualLabel );
        Assert.assertEquals( expectedStdOut, actualStdOut );
    }
}
