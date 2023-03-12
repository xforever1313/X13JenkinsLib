//
//          Copyright Seth Hendrick 2020-2023.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

package net.shendrick.X13JenkinsLib.test

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.*

class X13PathCombineTests extends BasePipelineTest
{
   // ---------------- Fields ----------------

   def uut;

   // ---------------- Setup / Teardown ----------------

    @Override
    @Before
    void setUp() throws Exception
    {
        super.setUp();
        this.uut = loadScript( "vars/X13PathCombine.groovy" );
    }

    // ---------------- Tests ----------------

    @Test
    void TwoPathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2" );

        // Check
        Assert.assertEquals(
            "1/2",
            actualPath
        );
    }

    @Test
    void TwoPathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2" );

        // Check
        Assert.assertEquals(
            "1\\2",
            actualPath
        );
    }

    @Test
    void ThreePathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3" );

        // Check
        Assert.assertEquals(
            "1/2/3",
            actualPath
        );
    }

    @Test
    void ThreePathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3" );

        // Check
        Assert.assertEquals(
            "1\\2\\3",
            actualPath
        );
    }

    @Test
    void FourPathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4" );

        // Check
        Assert.assertEquals(
            "1/2/3/4",
            actualPath
        );
    }

    @Test
    void FourPathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4",
            actualPath
        );
    }

    @Test
    void FivePathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5" );

        // Check
        Assert.assertEquals(
            "1/2/3/4/5",
            actualPath
        );
    }

    @Test
    void FivePathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4\\5",
            actualPath
        );
    }

    @Test
    void SixPathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6" );

        // Check
        Assert.assertEquals(
            "1/2/3/4/5/6",
            actualPath
        );
    }

    @Test
    void SixPathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4\\5\\6",
            actualPath
        );
    }

    @Test
    void SevenPathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7" );

        // Check
        Assert.assertEquals(
            "1/2/3/4/5/6/7",
            actualPath
        );
    }

    @Test
    void SevenPathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4\\5\\6\\7",
            actualPath
        );
    }

    @Test
    void EightPathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7", "8" );

        // Check
        Assert.assertEquals(
            "1/2/3/4/5/6/7/8",
            actualPath
        );
    }

    @Test
    void EightPathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7", "8" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4\\5\\6\\7\\8",
            actualPath
        );
    }

   @Test
    void NinePathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7", "8", "9" );

        // Check
        Assert.assertEquals(
            "1/2/3/4/5/6/7/8/9",
            actualPath
        );
    }

    @Test
    void NinePathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7", "8", "9" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4\\5\\6\\7\\8\\9",
            actualPath
        );
    }

   @Test
    void TenPathUnixTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return true;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" );

        // Check
        Assert.assertEquals(
            "1/2/3/4/5/6/7/8/9/10",
            actualPath
        );
    }

    @Test
    void TenPathWindowsTest()
    {
        // Setup
        helper.registerAllowedMethod(
            "isUnix",
            [],
            {
                return false;
            }
        );

        // Act
        String actualPath = this.uut.call( "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" );

        // Check
        Assert.assertEquals(
            "1\\2\\3\\4\\5\\6\\7\\8\\9\\10",
            actualPath
        );
    }
}
