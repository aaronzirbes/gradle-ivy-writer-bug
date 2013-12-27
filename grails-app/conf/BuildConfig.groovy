grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

// Change this to 1.6 if you're using Java 6
grails.project.target.level = 1.7
grails.project.source.level = 1.7

grails.project.dependency.resolution = {
    inherits("global") { }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies { }

    plugins { }
}
