@echo on
@echo =============================================================
@echo $                                                           $
@echo $                     Nepxion Deployment                    $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Nepxion Technologies All Right Reserved                  $
@echo $  Copyright(C) 2010                                        $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title Nepxion Deployment 
@color 0a

copy ..\..\application\lib\nepxion-util.jar ..\lib\
copy ..\..\application\lib\nepxion-swing.jar ..\lib\
copy ..\..\application\lib\nepxion-cots.jar ..\lib\
copy ..\..\application\lib\nepxion-swing-demo.jar ..\lib\

cd ..\sign\
sign-[nepxion-all].bat