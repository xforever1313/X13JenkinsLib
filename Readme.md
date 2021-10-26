X13 Jenkins Library
======================

A series of Jenkins functions I use for my personal setup.  Feel free to copy/paste and use for your own things!

Design Overview
--------

Everything with in the "vars" folder should be considered "public".  Anything within the "src" folder should be considered "private" and should not be called directly.

Almost all functions within the "vars" folder take in a map instead of arguments for ALL arguments.
The reason is so it is easy to overload functions or deprecate parameters in the future.

All functions in the "vars" are prefixed with "X13" so it is obvious which library a pipeline is calling.

What does X13 mean?
--------

Its the first character and last two characters of my username xforever1313.  I couldn't think of anything more creative, okay?

Running Unit Tests
--------
* Install a version of Java.  OpenJDK is recommended.  If on Windows, this can be installed with Chocolatey ```choco install openjdk8 -y```.
** Version 8 (Java 1.8) is recommended.  Otherwise, very strange warnings happen.
* Install Gradle.  If on Windows, this can be installed with Chocolatey ```choco install gradle -y```.
* Open a terminal and enter the root of this directory.
* Run ```gradle build```.

License
--------

Released under the [Boost Software License](https://www.boost.org/users/license.html)
