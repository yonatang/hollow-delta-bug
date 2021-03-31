This repo contains a minimal example to reproduce an issue with Hollow's snapshot consumption

Run the code in [Consumer.kt](src/main/kotlin/Consumer.kt), it will fetch two snapshots without using the delta files.

If the `consumer.getAPI(EntityApi::class.java)` will be called after each `triggerRefreshTo()`, 
`EntityApi` class will provide fresh data.

If the `consumer.getAPI(EntityApi::class.java)` will only be called once, `EntityApi` will provide stale
data.

If the `consumer.getAPI(EntityApi::class.java)` will only be called once, but the delta file will be available,
`EntityApi` class will provide fresh data.


Important! Please make sure you have git-lfs installed first.
