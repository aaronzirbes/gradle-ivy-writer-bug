Gradle 1.10 bug
===============

Expected vs. Actual
-------------------

The expected output is:

    <dependency org="javax.servlet" name="jstl" rev="1.1.2" force="true" conf="provided->compile(*),provided(*),runtime(*),master(*)"/>

But instead, Gradle 1.10 produces (note the &amp;gt;):

    <dependency org="javax.servlet" name="jstl" rev="1.1.2" force="true" conf="provided-&gt;compile(*),provided(*),runtime(*),master(*)"/>

Gradle Output
-------------

The output error returned by Gradle is

    :grails-clean FAILED

    FAILURE: Build failed with an exception.

    * What went wrong:
    Execution failed for task ':grails-clean'.
    > Could not resolve all dependencies for configuration ':test'.
       > Could not resolve >
               <e:rg="org.codehaus.groo:ule="groovy-a.
         Required by:
             org.gradle.bugs.example:gradle-ivy-writer-bug:0.1 > org.grails:grails-dependencies:2.2.4
          > Illegal character in path at index 35: http://repo.grails.org/grails/repo/>
                  <e/rg="org.codehaus.groo/ule="groovy-a/rg="org.codehaus.groo-ule="groovy-a.pom
          > Illegal character in path at index 34: http://repo.springsource.org/repo/>
                  <e/rg="org.codehaus.groo/ule="groovy-a/rg="org.codehaus.groo-ule="groovy-a.pom
          > Illegal character in path at index 30: http://repo1.maven.org/maven2/>
                  <e/rg="org.codehaus.groo/ule="groovy-a/rg="org.codehaus.groo-ule="groovy-a.pom

    * Try:
    Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

    BUILD FAILED



To reproduce usign GVM
----------------------

Works:

    rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && gvm use gradle 1.9 && gradle clean

Does not work:

    rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && gvm use gradle 1.10 && gradle clean

To reproduce using gradlew
--------------------------

Works:

    git co 1.9-works && rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && ./gradlew clean

Does not work:

    git co 1.10-fails && rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && ./gradlew clean

Bad output
----------

You can find the affected ivy.xml files with the following grep command

    grep -r --include '*.xml' -E "\-\&gt;" ~/.gradle/caches/modules-2/

