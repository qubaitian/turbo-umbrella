set REPOSITORY_PATH= C:\Users\Administrator\.m2\repository
rem searching
for /f "delims=" %%i in ('dir /b /s "%REPOSITORY_PATH%\*lastUpdated*"') do (
    del /s /q %%i
)
rem ok..
pause