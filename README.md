# enumeratum-circe update problem

This repo tries to showcase an issue with updating [enumeratum-circe](https://github.com/lloydmeta/enumeratum#circe) in Scala.

Affected:

- `sbt` 1.0.3, 1.0.5

Not affected:

- `sbt` 0.13.16

## Steps to replicate

System: macOS 10.13.1 with Homebrew

In `project/build.properties`:

```
sbt.version=1.0.3
```

Remove possible already loaded artefacts: 

```
$  rm -rf ~/.ivy2/cache/com.beachape/enumeratum-circe_2.12
```

```
$ sbt update
```

Expected:

- The artefacts would be installed

Actual:

- Error:

```
$ sbt update
[info] Loading settings from plugins.sbt ...
[info] Loading global plugins from /Users/asko/.sbt/1.0/plugins
[info] Loading project definition from /Users/asko/Sources/enumeratum-circe-update-problem/project
[info] Updating {file:/Users/asko/Sources/enumeratum-circe-update-problem/project/}enumeratum-circe-update-problem-build...
[info] Done updating.
[info] Loading settings from build.sbt ...
[info] Set current project to main (in build file:/Users/asko/Sources/enumeratum-circe-update-problem/)
[info] Updating {file:/Users/asko/Sources/enumeratum-circe-update-problem/}main...
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	::          UNRESOLVED DEPENDENCIES         ::
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	:: com.beachape#enumeratum-circe_2.12;1.5.14: 1
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 
[warn] 	Note: Unresolved dependencies path:
[warn] 		com.beachape:enumeratum-circe_2.12:1.5.14 (/Users/asko/Sources/enumeratum-circe-update-problem/build.sbt#L18)
[warn] 		  +- who:main_2.12:0.0.0
[error] sbt.librarymanagement.ResolveException: unresolved dependency: com.beachape#enumeratum-circe_2.12;1.5.14: 1
[error] 	at sbt.internal.librarymanagement.IvyActions$.resolveAndRetrieve(IvyActions.scala:331)
[error] 	at sbt.internal.librarymanagement.IvyActions$.$anonfun$updateEither$1(IvyActions.scala:205)
[error] 	at sbt.internal.librarymanagement.IvySbt$Module.$anonfun$withModule$1(Ivy.scala:229)
[error] 	at sbt.internal.librarymanagement.IvySbt.$anonfun$withIvy$1(Ivy.scala:190)
[error] 	at sbt.internal.librarymanagement.IvySbt.sbt$internal$librarymanagement$IvySbt$$action$1(Ivy.scala:70)
[error] 	at sbt.internal.librarymanagement.IvySbt$$anon$3.call(Ivy.scala:77)
[error] 	at xsbt.boot.Locks$GlobalLock.withChannel$1(Locks.scala:93)
[error] 	at xsbt.boot.Locks$GlobalLock.xsbt$boot$Locks$GlobalLock$$withChannelRetries$1(Locks.scala:78)
[error] 	at xsbt.boot.Locks$GlobalLock$$anonfun$withFileLock$1.apply(Locks.scala:97)
[error] 	at xsbt.boot.Using$.withResource(Using.scala:10)
[error] 	at xsbt.boot.Using$.apply(Using.scala:9)
[error] 	at xsbt.boot.Locks$GlobalLock.ignoringDeadlockAvoided(Locks.scala:58)
[error] 	at xsbt.boot.Locks$GlobalLock.withLock(Locks.scala:48)
[error] 	at xsbt.boot.Locks$.apply0(Locks.scala:31)
[error] 	at xsbt.boot.Locks$.apply(Locks.scala:28)
[error] 	at sbt.internal.librarymanagement.IvySbt.withDefaultLogger(Ivy.scala:77)
[error] 	at sbt.internal.librarymanagement.IvySbt.withIvy(Ivy.scala:185)
[error] 	at sbt.internal.librarymanagement.IvySbt.withIvy(Ivy.scala:182)
[error] 	at sbt.internal.librarymanagement.IvySbt$Module.withModule(Ivy.scala:228)
[error] 	at sbt.internal.librarymanagement.IvyActions$.updateEither(IvyActions.scala:190)
[error] 	at sbt.librarymanagement.ivy.IvyDependencyResolution.update(IvyDependencyResolution.scala:20)
[error] 	at sbt.librarymanagement.DependencyResolution.update(DependencyResolution.scala:56)
[error] 	at sbt.internal.LibraryManagement$.resolve$1(LibraryManagement.scala:38)
[error] 	at sbt.internal.LibraryManagement$.$anonfun$cachedUpdate$12(LibraryManagement.scala:91)
[error] 	at sbt.util.Tracked$.$anonfun$lastOutput$1(Tracked.scala:68)
[error] 	at sbt.internal.LibraryManagement$.$anonfun$cachedUpdate$19(LibraryManagement.scala:104)
[error] 	at scala.util.control.Exception$Catch.apply(Exception.scala:224)
[error] 	at sbt.internal.LibraryManagement$.$anonfun$cachedUpdate$11(LibraryManagement.scala:104)
[error] 	at sbt.internal.LibraryManagement$.$anonfun$cachedUpdate$11$adapted(LibraryManagement.scala:87)
[error] 	at sbt.util.Tracked$.$anonfun$inputChanged$1(Tracked.scala:149)
[error] 	at sbt.internal.LibraryManagement$.cachedUpdate(LibraryManagement.scala:118)
[error] 	at sbt.Classpaths$.$anonfun$updateTask$5(Defaults.scala:2353)
[error] 	at scala.Function1.$anonfun$compose$1(Function1.scala:44)
[error] 	at sbt.internal.util.$tilde$greater.$anonfun$$u2219$1(TypeFunctions.scala:42)
[error] 	at sbt.std.Transform$$anon$4.work(System.scala:64)
[error] 	at sbt.Execute.$anonfun$submit$2(Execute.scala:257)
[error] 	at sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:16)
[error] 	at sbt.Execute.work(Execute.scala:266)
[error] 	at sbt.Execute.$anonfun$submit$1(Execute.scala:257)
[error] 	at sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:167)
[error] 	at sbt.CompletionService$$anon$2.call(CompletionService.scala:32)
[error] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error] 	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:514)
[error] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
[error] 	at java.base/java.lang.Thread.run(Thread.java:844)
[error] (*:update) sbt.librarymanagement.ResolveException: unresolved dependency: com.beachape#enumeratum-circe_2.12;1.5.14: 1
[error] Total time: 0 s, completed 14 Nov 2017, 22.02.59
```

If we change `project/build.properties` to have:

```
sbt.version=0.13.16
```

... update happens, but there are warnings (not sure if they are connected with the issue);

```
$ sbt update
[info] Loading global plugins from /Users/asko/.sbt/0.13/plugins
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by sbt.ivyint.ErrorMessageAuthenticator$ (file:/Users/asko/.sbt/boot/scala-2.10.6/org.scala-sbt/sbt/0.13.16/ivy-0.13.16.jar) to field java.net.Authenticator.theAuthenticator
WARNING: Please consider reporting this to the maintainers of sbt.ivyint.ErrorMessageAuthenticator$
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[info] Loading project definition from /Users/asko/Sources/enumeratum-circe-update-problem/project
[info] Set current project to main (in build file:/Users/asko/Sources/enumeratum-circe-update-problem/)
[info] Updating {file:/Users/asko/Sources/enumeratum-circe-update-problem/}main...
[info] Resolving jline#jline;2.14.5 ...
[info] downloading https://repo1.maven.org/maven2/com/beachape/enumeratum-circe_2.12/1.5.14/enumeratum-circe_2.12-1.5.14.jar ...
[info] 	[SUCCESSFUL ] com.beachape#enumeratum-circe_2.12;1.5.14!enumeratum-circe_2.12.jar (1052ms)
[info] Done updating.
[success] Total time: 5 s, completed 14 Nov 2017, 22.02.17
```

## Fixes

- Downgrade `project/build.properties` temporarily to `0.13.16`, do an update, then place the `1.0.x` back. 
  Since the artefacts are loaded in a local Ivy2 repo (common to all sbt versions), they are now visible for `1.0.x` as well.

- Adding this: `updateOptions := updateOptions.value.withGigahorse(false)` to `build.sbt` sometimes works, but mostly not. I wasn't able to figure out the logic.

