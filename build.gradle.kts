plugins {
    id("de.themoep.randomteleport.java-conventions")
}

dependencies {
    api(project(":randomteleport-api"))
    api(project(":randomteleport-plugin"))
    api(project(":randomteleport-hook"))
    api(project(":worldguard-7"))
    api(project(":chunkyborder"))
    api(project(":griefdefender"))
}

description = "randomteleport-plugin"
