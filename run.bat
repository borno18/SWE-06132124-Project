@echo off
if not exist out mkdir out
javac -d out src\game\main\Main.java src\game\ui\GamePanel.java src\game\model\Entity.java src\game\model\Player.java src\game\model\Collectible.java
if errorlevel 1 exit /b 1
java -cp out game.main.Main
