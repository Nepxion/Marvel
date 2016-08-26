@echo on
@echo =============================================================
@echo $                                                           $
@echo $                     Nepxion Signature                     $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Nepxion Technologies All Right Reserved                  $
@echo $  Copyright(C) 2010                                        $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title Nepxion Signature
@color 0a

set JAVA_HOME=E:\Tool\JDK-1.6.0

%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/nepxion-cots.jar security