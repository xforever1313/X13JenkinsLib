//
//          Copyright Seth Hendrick 2020-2022.
// Distributed under the Boost Software License, Version 1.0.
//    (See accompanying file LICENSE_1_0.txt or copy at
//          https://www.boost.org/LICENSE_1_0.txt)
//

/// \brief - Parses the test results from an MS Test file.
///          Optionally fails the build if desired.
///
/// \param filePattern - The pattern the MSTest XML files to parse.
/// \param abortOnFail - Boolean.  Set to true to fail the build
///                      if there are any failures.
///                      Defaulted to false.
def call( Map args )
{
    X13NotNull( args.filePattern );

    // results is a TestResultSummary object.
    // Seen here: https://javadoc.jenkins.io/plugin/junit/hudson/tasks/junit/TestResultSummary.html

    def results = xunit thresholds: [
        failed(failureNewThreshold: '0', failureThreshold: '0', unstableNewThreshold: '0', unstableThreshold: '0')
    ], tools: [
        NUnit3(
            deleteOutputFiles: true,
            failIfNotNew: true,
            pattern: args.filePattern,
            skipNoTestFiles: true,
            stopProcessingIfError: true
        )
    ];

    if( args.abortOnFail )
    {
        if( results.getFailCount() > 0 )
        {
            error "At least one test failed.  Total failures: ${results.getFailCount()}";
        }
    }
}
