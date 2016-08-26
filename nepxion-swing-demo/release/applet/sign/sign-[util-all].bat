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

%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/commons-lang-3-3.0-beta.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/commons-logging-1.1.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/dom4j-1.6.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/http-client-4.0.3.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/http-core-4.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/jacob-1.15.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/jdom-1.1.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/json.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/junit-4.8.2.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/log4j-1.2.16.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/ojdbc14-10g.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/poi-3.7-20101029.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/proxool-0.9.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/proxool-cglib.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/quartz-all-1.8.4.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/servlet-api.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/slf4j-api-1.6.1.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/util/slf4j-log4j12-1.6.1.jar security