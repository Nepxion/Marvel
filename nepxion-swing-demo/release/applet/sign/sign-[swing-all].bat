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

%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/alloy-skin-1.4.4.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/borland-skin-2006.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/itext-2.1.7.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/itext-asian.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jcalendar-1.3.4.200905090658.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jcommon-1.0.16.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jdesktop-swing-worker-1.2.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jdesktop-swingx-1.6.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jfreechart-1.0.13.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jfreechart-1.0.13-experimental.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jgoodies-forms-1.3.0.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jgoodies-skin-2.1.4.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/jide-oss-2.9.7.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/l2fprod-common-all-7.3.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/native-skin-6.7.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/plugin.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/tiny-skin.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/trayIcon-1.7.9B.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/vldocking-2.1.5.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/swing/xp-skin.jar security