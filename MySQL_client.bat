call MySQL_path.bat
::cd .\bin\
::chcp 866
mysql --user=root --password=password
if ERRORLEVEL 1 pause