@echo on
@echo =============================================================
@echo $                                                           $
@echo $                       Nepxion Swing                       $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Nepxion Technologies All Right Reserved                  $
@echo $  Copyright(C) 2010                                        $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@rem ======================================
@rem DOS Batch file to invoke the Swing UI
@rem ======================================

@title Nepxion Swing 
@color 0a
 	 			
rem if "%JAVA_HOME%"=="" goto noJava

if "%JAVA_HOME%"=="" set JAVA_HOME=C:\JDK1.6.0

@set CLASSPATH=.;.\conf\;.\data\;.\lib\util\jacob-1.15.jar;.\lib\nepxion-util.jar;.\lib\nepxion-swing.jar;.\lib\nepxion-swing-demo.jar;
@set PATH=.\lib\util\native;.\lib\swing\native;

%JAVA_HOME%\bin\java -Dfile.encoding=GBK -Ddefault.client.encoding=GBK -Duser.language=zh -Duser.region=CN -Djava.security.policy=java.policy -Djava.library.path=%PATH% -Xms128m -Xmx512m -classpath %CLASSPATH% com.nepxion.demo.DemoDockableFrame