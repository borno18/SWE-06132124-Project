# SWE-06132124-Project
Catch the Square is a simple, fast-paced arcade game built with Java Swing. Control the blue paddle at the bottom of the screen to catch falling red collectibles and rack up your score!

## Run

From the project root:

```powershell
.\run.bat
```

Or compile and run manually:

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out game.main.Main
```
