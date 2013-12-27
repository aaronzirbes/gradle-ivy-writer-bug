Gradle 1.10 bug
===============

To reproduce usign GVM
----------------------

Works:

    rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && gvm use gradle 1.9 && gradle clean assemble

Does not work:

    rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && gvm use gradle 1.10 && gradle clean assemble

To reproduce using gradlew
--------------------------

Works:

    git co 1.9-works && rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && ./gradlew clean assemble

Does not work:

    git co 1.10-fails && rm -rf ~/.gradle/caches/1.* ~/.gradle/caches/modules-2 && ./gradlew clean assemble
