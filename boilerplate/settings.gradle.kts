plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "boilerplate"
include("domain")
include("application")
include("adapter")
include("infrastructure")
include("cmd")
