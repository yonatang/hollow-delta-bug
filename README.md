This repo contains a minimal example to reproduce an issue with Hollow's delta consumption in Hollow 5.2.x.

Run the code in Consumer.kt, it will fail with the following error:

```kotlin
Exception in thread "main" java.lang.RuntimeException: java.io.EOFException
	at com.netflix.hollow.api.consumer.HollowConsumer.triggerRefreshTo(HollowConsumer.java:297)
	at ConsumerKt.main(Consumer.kt:23)
	at ConsumerKt.main(Consumer.kt)
Caused by: java.io.EOFException
	at java.base/java.io.DataInputStream.readFully(DataInputStream.java:202)
	at java.base/java.io.DataInputStream.readLong(DataInputStream.java:421)
	at com.netflix.hollow.core.read.HollowBlobInput.readLong(HollowBlobInput.java:237)
	at com.netflix.hollow.core.read.engine.SnapshotPopulatedOrdinalsReader.readOrdinals(SnapshotPopulatedOrdinalsReader.java:38)
```

While if you change the version to 5.1.x, it will work just fine.

Important! Please make sure you have git-lfs installed first.
