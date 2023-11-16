@echo off
echo Executando o programa

REM Executa o programa
kotlinc -include-runtime -d programa.jar BlogThymeleafTutorialApplication.kt

REM Aguarda 3 segundos
timeout /t 3

REM abre o navegador no endereço localhost:8080/login
start http://localhost:8080/login